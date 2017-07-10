package com.testbook.mvc.services.impl;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.domain.Genre;
import com.testbook.mvc.dto.AuthorDto;
import com.testbook.mvc.dto.GenreDto;
import com.testbook.mvc.exceptions.GenreExistException;
import com.testbook.mvc.exceptions.GenreServiceException;
import com.testbook.mvc.repository.GenreRepository;
import com.testbook.mvc.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Override
    public void saveGenre(GenreDto genreDto) {
        Genre genre = new Genre.Builder().setName(genreDto).build();
        try {
            genreRepository.saveGenre(genre);
        }catch (GenreExistException ex){
            throw new GenreServiceException(ex.getMessage());
        }
    }

    @Override
    public List<GenreDto> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        List<GenreDto> genreDtos = new ArrayList<>();
        for (Genre genre: genres) {
            GenreDto genreDto = new GenreDto.Builder().setName(genre).build();
            genreDtos.add(genreDto);
        }
        return genreDtos;
    }
}

package com.testbook.mvc.services;

import com.testbook.mvc.domain.Genre;
import com.testbook.mvc.dto.AuthorDto;
import com.testbook.mvc.dto.GenreDto;

import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
public interface GenreService {

    void saveGenre(GenreDto genreDto);
    List<GenreDto> getAllGenres();

}

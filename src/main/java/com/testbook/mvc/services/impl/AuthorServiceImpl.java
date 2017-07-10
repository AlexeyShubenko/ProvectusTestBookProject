package com.testbook.mvc.services.impl;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.dto.AuthorDto;
import com.testbook.mvc.dto.BookDto;
import com.testbook.mvc.exceptions.AuthorExistException;
import com.testbook.mvc.exceptions.AuthorServiceException;
import com.testbook.mvc.repository.AuthorRepository;
import com.testbook.mvc.repository.BookRepository;
import com.testbook.mvc.repository.GenreRepository;
import com.testbook.mvc.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public void saveAuthor(AuthorDto authorDto){
        Author author = new Author.Builder().setName(authorDto).build();
        try {
            authorRepository.saveAuthor(author);
        }catch (AuthorExistException ex){
            throw new AuthorServiceException(ex.getMessage());
        }
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author:authors) {
            AuthorDto authorDto = new AuthorDto.Builder().setName(author).build();
            authorDtos.add(authorDto);
        }
        return authorDtos;
    }
}

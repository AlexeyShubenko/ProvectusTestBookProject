package com.testbook.mvc.services;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.dto.AuthorDto;

import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
public interface AuthorService {

    void saveAuthor(AuthorDto authorDto);
    List<AuthorDto> getAllAuthors();

}

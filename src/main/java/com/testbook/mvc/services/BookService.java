package com.testbook.mvc.services;

import com.testbook.mvc.dto.BookDto;

import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
public interface BookService {

    void saveBook(BookDto bookDto);
    List<BookDto> getAllBooks();
    List<BookDto> getAllBooksByParameter(String parameter,String searchBy);

}

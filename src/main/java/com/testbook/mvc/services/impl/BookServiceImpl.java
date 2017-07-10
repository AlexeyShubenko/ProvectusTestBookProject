package com.testbook.mvc.services.impl;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.domain.Book;
import com.testbook.mvc.domain.Genre;
import com.testbook.mvc.dto.AuthorDto;
import com.testbook.mvc.dto.BookDto;
import com.testbook.mvc.dto.BookOrderDto;
import com.testbook.mvc.dto.GenreDto;
import com.testbook.mvc.repository.AuthorRepository;
import com.testbook.mvc.repository.BookRepository;
import com.testbook.mvc.repository.GenreRepository;
import com.testbook.mvc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Alexey on 27.06.2017.
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,GenreRepository genreRepository){
        this.bookRepository=bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void saveBook(BookDto bookDto) {
        String[] authorNames = bookDto.getAuthors().split(",");
        String[] genreNames = bookDto.getGenres().split(",");

        Book book = new Book.Builder().setTitle(bookDto)
                .setDescription(bookDto)
                .setPrice(bookDto)
                .build();
        List<Author> authors = new ArrayList<>();
        for (String authorName:authorNames) {
            authors.add(authorRepository.findAuthorByName(authorName.trim()));
        }
        List<Genre> genres = new ArrayList<>();
        for (String genreName:genreNames) {
            genres.add(genreRepository.findGenreByName(genreName.trim()));
        }
        for (int i = 0; i < authors.size(); i++) {
            book.getAuthors().add(authors.get(i));

        }
        for (int i = 0; i < genres.size(); i++) {
            book.getGenres().add(genres.get(i));
        }
        System.out.println(book.getAuthors().get(0).getName());
        System.out.println(book.getGenres().get(0).getName());
        bookRepository.save(book);

    }

    @Override
    @Transactional
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = books.stream().map(book -> new BookDto.Builder()
                .setTitle(book)
                .setDescription(book)
                .setPrice(book)
                .setGenres(book)
                .setAuthors(book)
                .build())
                .collect(Collectors.toList());
        return bookDtos;
    }

    @Override
    @Transactional
    public List<BookDto> getAllBooksByParameter(String parameter,String searchBy) {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = books.stream().map(book -> new BookDto.Builder()
                .setTitle(book)
                .setDescription(book)
                .setPrice(book)
                .setGenres(book)
                .setAuthors(book)
                .build())
                .collect(Collectors.toList());
        List<BookDto> sortedBook = new ArrayList<>();
        if (searchBy.equals("byAuthorName")) {
            for (int i = 0; i < books.size(); i++) {
                List<Author> authors = books.get(i).getAuthors();
                for (Author a : authors) {
                    if (a.getName().equals(parameter)) {
                        //take book from dtos
                        sortedBook.add(bookDtos.get(i));
                        break;
                    }
                }
            }

        } else if (searchBy.equals("byGenreName")) {
            for (int i = 0; i < books.size(); i++) {
                List<Genre> genres = books.get(i).getGenres();
                for (Genre g : genres) {
                    if (g.getName().equals(parameter)) {
                        //take book from dtos
                        sortedBook.add(bookDtos.get(i));
                        break;
                    }
                }
            }
        }

        return sortedBook;
    }
}

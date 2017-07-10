package com.testbook.mvc.dto;


import com.testbook.mvc.domain.Author;
import com.testbook.mvc.domain.Book;
import com.testbook.mvc.domain.Genre;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * Created by Alexey on 27.06.2017.
 */

public class BookDto {

    @NotNull
    @Size(min = 2, message = "{book.fields}")
    private String title;
    @NotNull@Size(min = 5, message = "{book.fields}")
    private String description;
    @NotNull(message = "{book.fields}")
    private Integer price;
    @NotNull
    @Size(min = 5,message = "{book.fields}")
    private String authors;
    @NotNull
    @Size(min = 5,message = "{book.fields}")
    private String genres;

    public BookDto(){}

    public static class Builder{

        BookDto bookDto = new BookDto();

        public Builder setTitle(Book book){
            bookDto.setTitle(book.getTitle());
            return this;
        }

        public Builder setDescription(Book book){
            bookDto.setDescription(book.getDescription());
            return this;
        }

        public Builder setPrice(Book book){
            bookDto.setPrice(book.getPrice());
            return this;
        }

        public Builder setGenres(Book book){
            List<Genre> genres = book.getGenres();
            String genresString="";
            for (Genre genre: genres){
                genresString+=" " + genre.getName();
            }
            bookDto.setGenres(genresString.trim());
            return this;
        }

        public Builder setAuthors(Book book){
            List<Author> authors = book.getAuthors();
            String authorsString="";
            for (Author author: authors){
                authorsString+=" " +author.getName();
            }
            bookDto.setAuthors(authorsString.trim());
            return this;
        }

        public BookDto build(){
            return bookDto;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}

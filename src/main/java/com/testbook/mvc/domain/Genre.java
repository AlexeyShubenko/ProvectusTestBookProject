package com.testbook.mvc.domain;

import com.testbook.mvc.dto.GenreDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Book> books = new ArrayList<>();

    public Genre(){}

    public static class Builder{
        Genre genre = new Genre();

        public Builder setName(GenreDto genreDto){
            genre.setName(genreDto.getName());
            return this;
        }

        public Genre build(){
            return genre;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

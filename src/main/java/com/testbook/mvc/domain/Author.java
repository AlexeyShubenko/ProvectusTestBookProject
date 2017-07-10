package com.testbook.mvc.domain;

import com.testbook.mvc.dto.AuthorDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public Author(){}

    public static class Builder{
        Author author = new Author();

        public Builder setName(AuthorDto authorDto){
            author.setName(authorDto.getName());
            return this;
        }

        public Author build(){
            return author;
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

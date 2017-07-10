package com.testbook.mvc.domain;

import com.testbook.mvc.dto.BookDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Integer price;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "books_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id",referencedColumnName = "id"))
    private List<Author> authors = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "books_id",referencedColumnName = "id"),
              inverseJoinColumns = @JoinColumn(name = "genres_id",referencedColumnName = "id"))
    private List<Genre> genres = new ArrayList<>();
    @OneToMany(mappedBy = "book")
    private List<BookOrder> bookOrders = new ArrayList<>();

    public Book(){}

    public static class Builder{

        Book book = new Book();

        public Builder setTitle(BookDto bookDto){
            book.setTitle(bookDto.getTitle());
            return this;
        }

        public Builder setDescription(BookDto bookDto){
            book.setDescription(bookDto.getDescription());
            return this;
        }

        public Builder setPrice(BookDto bookDto){
            book.setPrice(bookDto.getPrice());
            return this;
        }

        public Book build(){
            return book;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<BookOrder> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(List<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }
}

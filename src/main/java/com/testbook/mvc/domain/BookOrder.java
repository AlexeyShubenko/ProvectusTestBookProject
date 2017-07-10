package com.testbook.mvc.domain;

import com.testbook.mvc.dto.BookOrderDto;
import javax.persistence.*;

/**
 * Created by Alexey on 02.07.2017.
 */
@Entity
@Table(name = "bookorder")
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String address;
    @Column
    private Integer booksQuantity;
    @ManyToOne
    private Book book;

    public static class Builder{

        BookOrder bookOrder = new BookOrder();

        public Builder setFirstName(BookOrderDto bookOrderDto){
            bookOrder.setFirstName(bookOrderDto.getFirstName());
            return this;
        }
        public Builder setLastName(BookOrderDto bookOrderDto){
            bookOrder.setLastName(bookOrderDto.getLastName());
            return this;
        }
        public Builder setAddress(BookOrderDto bookOrderDto){
            bookOrder.setAddress(bookOrderDto.getAddress());
            return this;
        }
        public Builder setBooksQuantity(BookOrderDto bookOrderDto){
            bookOrder.setBooksQuantity(bookOrderDto.getBooksQuantity());
            return this;
        }
        public BookOrder build(){
            return bookOrder;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBooksQuantity() {
        return booksQuantity;
    }

    public void setBooksQuantity(Integer booksQuantity) {
        this.booksQuantity = booksQuantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", booksQuantity=" + booksQuantity +
                '}';
    }
}

package com.testbook.mvc.dto;

import com.testbook.mvc.domain.BookOrder;

import javax.validation.constraints.NotNull;

/**
 * Created by Alexey on 02.07.2017.
 */

public class BookOrderDto {

    private String firstName;
    private String lastName;
    private String bookTitle;
    private String address;
    private Integer booksQuantity;

    public static class Builder{
        BookOrderDto bookOrderDto = new BookOrderDto();

        public Builder setFirstName(BookOrder bookOrder){
            this.bookOrderDto.setFirstName(bookOrder.getFirstName());
            return this;
        }
        public Builder setLastName(BookOrder bookOrder){
            this.bookOrderDto.setLastName(bookOrder.getLastName());
            return this;
        }
        public Builder setAddress(BookOrder bookOrder){
            this.bookOrderDto.setAddress(bookOrder.getAddress());
            return this;
        }
        public Builder setBooksQuantity(BookOrder bookOrder){
            this.bookOrderDto.setBooksQuantity(bookOrder.getBooksQuantity());
            return this;
        }
        public BookOrderDto build(){
            return bookOrderDto;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "BookOrderDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", address='" + address + '\'' +
                ", booksQuantity=" + booksQuantity +
                '}';
    }
}

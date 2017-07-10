package com.testbook.mvc.dto;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.domain.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
public class AuthorDto {

    @NotNull
    @Size(min = 1, message = "{message.author.name.err}")
    private String name;

    public static class Builder{
        AuthorDto authorDto = new AuthorDto();

        public Builder setName(Author author){
            authorDto.setName(author.getName());
            return this;
        }

        public AuthorDto build(){
            return authorDto;
        }
    }


    public AuthorDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

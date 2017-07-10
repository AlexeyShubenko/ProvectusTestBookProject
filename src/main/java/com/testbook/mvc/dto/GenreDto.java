package com.testbook.mvc.dto;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.domain.Genre;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Alexey on 27.06.2017.
 */
public class GenreDto {

    @NotNull
    @Size(min = 1, message = "{message.genre.name.err}")
    private String name;

    public GenreDto(){}

    public static class Builder{
        GenreDto genreDto = new GenreDto();

        public Builder setName(Genre genre){
            genreDto.setName(genre.getName());
            return this;
        }

        public GenreDto build(){
            return genreDto;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

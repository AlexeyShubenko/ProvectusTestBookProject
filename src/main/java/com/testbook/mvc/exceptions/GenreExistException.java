package com.testbook.mvc.exceptions;

/**
 * Created by Alexey on 27.06.2017.
 */
public class GenreExistException extends RuntimeException {

    public GenreExistException(String message){
        super(message);
    }

}

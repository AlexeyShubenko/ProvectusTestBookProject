package com.testbook.mvc.exceptions;

/**
 * Created by Alexey on 27.06.2017.
 */
public class AuthorExistException extends RuntimeException {

    public AuthorExistException(String message){
        super(message);
    }

}

package com.testbook.mvc.exceptions;


/**
 * Created by Alexey on 27.06.2017.
 */
public class AuthorServiceException extends RuntimeException {

    public AuthorServiceException(String message){
        super(message);
    }

}

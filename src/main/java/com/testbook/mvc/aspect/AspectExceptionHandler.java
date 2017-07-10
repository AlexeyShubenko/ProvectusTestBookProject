package com.testbook.mvc.aspect;

import com.testbook.mvc.exceptions.AuthorServiceException;
import com.testbook.mvc.exceptions.GenreExistException;
import com.testbook.mvc.exceptions.GenreServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexey on 27.05.2017.
 */
@ControllerAdvice
public class AspectExceptionHandler {

    @ExceptionHandler(GenreServiceException.class)
    public RedirectView handlGenreServiceException(GenreServiceException exception, HttpServletRequest request) {
        RedirectView rw = new RedirectView("./addgenre");
        rw.setStatusCode(HttpStatus.MOVED_PERMANENTLY);

        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        if (outputFlashMap != null){
            outputFlashMap.put("error", exception.getMessage());
        }
        return rw;
    }

    @ExceptionHandler(AuthorServiceException.class)
    public RedirectView handleAuthorException(AuthorServiceException ex, HttpServletRequest request){
        RedirectView redirectView = new RedirectView("./addauthor");
        redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        if (outputFlashMap != null){
            outputFlashMap.put("error", ex.getMessage());
        }
        return redirectView;

    }
//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception ex){
//        ex.printStackTrace();
//        return "/index";
//    }

}

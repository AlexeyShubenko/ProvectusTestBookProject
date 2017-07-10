package com.testbook.mvc.repository.impl;

import com.testbook.mvc.domain.Genre;
import com.testbook.mvc.exceptions.GenreExistException;
import com.testbook.mvc.repository.GenreRepositoryCustom;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created by Alexey on 28.06.2017.
 */
@Repository
public class GenreRepositoryImpl implements GenreRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MessageSource messageSource;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveGenre(Genre genre) {
        try {
            em.persist(genre);
            em.flush();
        }catch (PersistenceException ex){
            if(ex.getCause() instanceof ConstraintViolationException){
                throw new GenreExistException(messageSource.getMessage("genre.exist",null, LocaleContextHolder.getLocale()));
            }else{
                throw new GenreExistException(messageSource.getMessage("db.error",null, LocaleContextHolder.getLocale()));
            }
        }
    }
}

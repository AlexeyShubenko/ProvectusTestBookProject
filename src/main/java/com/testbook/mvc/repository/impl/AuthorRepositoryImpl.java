package com.testbook.mvc.repository.impl;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.exceptions.AuthorExistException;
import com.testbook.mvc.repository.AuthorRepositoryCustom;
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
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MessageSource messageSource;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAuthor(Author author) {
        try{
            em.persist(author);
            em.flush();
        }catch (PersistenceException ex){
            if(ex.getCause() instanceof ConstraintViolationException){
                throw new AuthorExistException(messageSource.getMessage("author.exist",null,LocaleContextHolder.getLocale()));
            }else {
                throw new AuthorExistException(messageSource.getMessage("db.error",null,LocaleContextHolder.getLocale()));
            }
        }
    }
}

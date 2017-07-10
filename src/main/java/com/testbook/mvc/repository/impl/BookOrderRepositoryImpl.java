package com.testbook.mvc.repository.impl;

import com.testbook.mvc.domain.BookOrder;
import com.testbook.mvc.repository.BookOrderRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by Alexey on 03.07.2017.
 */
public class BookOrderRepositoryImpl implements BookOrderRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public BookOrder findOrderByAllParameters(BookOrder bookOrder) {
        try {
            BookOrder bookOrderNew = (BookOrder) em.createQuery("select o from BookOrder o where " +
                    "o.firstname=:firstname " +
                    "and o.lastname=:lastname " +
                    "and o.address=:address " +
                    "and o.booksQuantity=:booksQuantity " +
                    "and o.book.title=:title")
                    .setParameter("firstname", bookOrder.getFirstName())
                    .setParameter("lastname", bookOrder.getLastName())
                    .setParameter("address", bookOrder.getAddress())
                    .setParameter("booksQuantity", bookOrder.getBooksQuantity())
                    .setParameter("title", bookOrder.getBook().getTitle())
                    .getSingleResult();
            return bookOrderNew;
        }catch (NoResultException ex){
            return null;
        }
    }
}

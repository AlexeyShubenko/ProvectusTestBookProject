package com.testbook;

import com.testbook.mvc.domain.Admin;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Alexey on 27.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory =
                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager em = sessionFactory.createEntityManager();

    }

}

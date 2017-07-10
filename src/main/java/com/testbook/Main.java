package com.testbook;

import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Alexey on 27.06.2017.
 */
public class Main {

    public static void main(String[] args) {
//        SessionFactory sessionFactory =
//                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//        EntityManager em = sessionFactory.createEntityManager();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print( "j = " + j);
                if(j==5)break;
            }
            System.out.println();
        }

    }

}

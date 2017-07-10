package com.testbook.mvc.repository;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 27.06.2017.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorRepositoryCustom{

    Author findAuthorByName(String name);

}

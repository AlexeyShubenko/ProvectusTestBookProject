package com.testbook.mvc.repository;

import com.testbook.mvc.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

//    @Query("select b from Book b where title=:title")
    Book findBookByTitle(@Param("title") String title);

}

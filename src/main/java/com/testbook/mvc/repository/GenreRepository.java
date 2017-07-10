package com.testbook.mvc.repository;

import com.testbook.mvc.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 27.06.2017.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>, GenreRepositoryCustom{

    Genre findGenreByName(String name);

}

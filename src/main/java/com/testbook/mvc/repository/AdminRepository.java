package com.testbook.mvc.repository;

import com.testbook.mvc.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 16.07.2017.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("select a from Admin a where a.login=:login and a.password=:password ")
    Admin findAdminByLoginAndPassword(@Param("login") String login, @Param("password") String password);

}

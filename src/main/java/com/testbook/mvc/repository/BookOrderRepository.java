package com.testbook.mvc.repository;

import com.testbook.mvc.domain.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey on 03.07.2017.
 */
@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long> ,BookOrderRepositoryCustom{
}

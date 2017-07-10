package com.testbook.mvc.repository;

import com.testbook.mvc.domain.BookOrder;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Alexey on 03.07.2017.
 */
public interface BookOrderRepositoryCustom {

    BookOrder findOrderByAllParameters(BookOrder bookOrder);

}

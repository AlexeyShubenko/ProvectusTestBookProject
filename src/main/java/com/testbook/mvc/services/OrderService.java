package com.testbook.mvc.services;

import com.testbook.mvc.dto.BookOrderDto;

/**
 * Created by Alexey on 03.07.2017.
 */
public interface OrderService {

    boolean saveBookOrder(BookOrderDto bookOrderDto);

}

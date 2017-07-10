package com.testbook.mvc.services.impl;

import com.testbook.mvc.domain.Book;
import com.testbook.mvc.domain.BookOrder;
import com.testbook.mvc.dto.BookOrderDto;
import com.testbook.mvc.repository.BookOrderRepository;
import com.testbook.mvc.repository.BookRepository;
import com.testbook.mvc.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by Alexey on 03.07.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private BookOrderRepository bookOrderRepository;
    private BookRepository bookRepository;

    @Autowired
    public OrderServiceImpl(BookOrderRepository bookOrderRepository, BookRepository bookRepository) {
        this.bookOrderRepository = bookOrderRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public boolean saveBookOrder(BookOrderDto bookOrderDto) {
        Book book = bookRepository.findBookByTitle(bookOrderDto.getBookTitle());

        BookOrder bookOrder = new BookOrder.Builder()
                                .setFirstName(bookOrderDto)
                                .setLastName(bookOrderDto)
                                .setAddress(bookOrderDto)
                                .setBooksQuantity(bookOrderDto)
                        .build();
        bookOrder.setBook(book);
        BookOrder isExistBookOrder = bookOrderRepository.findOrderByAllParameters(bookOrder);
        if(Objects.nonNull(isExistBookOrder)){
            return false;
        }else {
            bookOrderRepository.save(bookOrder);
            return true;
        }

    }
}

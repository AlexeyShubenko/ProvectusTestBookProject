package com.testbook.mvc.controllers;


import com.testbook.mvc.dto.*;
import com.testbook.mvc.services.AuthorService;
import com.testbook.mvc.services.BookService;
import com.testbook.mvc.services.GenreService;
import com.testbook.mvc.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by Alexey on 27.06.2017.
 */
@RestController
public class MainController {

    private BookService bookService;
    private OrderService orderService;
    private AuthorService authorService;
    private GenreService genreService;

    @Autowired
    public MainController(BookService bookService,OrderService orderService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @RequestMapping(value = "/allbooks",method = RequestMethod.GET, name = "showAllBooks")
    public ModelAndView toMainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allbooks");
        return new ModelAndView();
    }

    @RequestMapping(value = "/showAllBooks",method = RequestMethod.GET)
    public List<BookDto> getAllBooks(){
        List<BookDto> books = bookService.getAllBooks();
        return books;
    }

    @RequestMapping(value = "/showAllBooksByParameter",method = RequestMethod.GET)
    public List<BookDto> getAllBooksByParameter(@RequestParam("parameter") String parameter,
                                     @RequestParam("searchBy") String searchBy){
        List<BookDto> books = bookService.getAllBooksByParameter(parameter,searchBy);
        return books;
    }


    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public OrderResponse saveOrder(@RequestBody BookOrderDto bookOrderDto){
        boolean isSuccess = orderService.saveBookOrder(bookOrderDto);

        if(isSuccess)
            return new OrderResponse(bookOrderDto.getFirstName(),
                    bookOrderDto.getLastName(),"Your order was successfully saved!");
        else
            return new OrderResponse(bookOrderDto.getFirstName(),
                    bookOrderDto.getLastName(),"Current order is already existed, try again!");
    }

    @RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET)
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @RequestMapping(value = "/getAllGenres", method = RequestMethod.GET)
    public List<GenreDto> getAllGenres(){
        return genreService.getAllGenres();
    }

}

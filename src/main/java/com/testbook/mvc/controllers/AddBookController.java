package com.testbook.mvc.controllers;

import com.testbook.mvc.domain.Author;
import com.testbook.mvc.domain.Genre;
import com.testbook.mvc.dto.AuthorDto;
import com.testbook.mvc.dto.BookDto;
import com.testbook.mvc.dto.GenreDto;
import com.testbook.mvc.services.AuthorService;
import com.testbook.mvc.services.BookService;
import com.testbook.mvc.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Alexey on 27.06.2017.
 */
@Controller
public class AddBookController {

    private BookService bookService;
    private AuthorService authorService;
    private GenreService genreService;

    @Autowired
    public AddBookController(BookService bookService,AuthorService authorService,GenreService genreService){
        this.bookService=bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @RequestMapping(value = "/addnewbook",method = RequestMethod.GET)
    public String addBook(Model model, HttpSession session){
        if(Objects.isNull(session.getAttribute("admin"))){
            return "redirect:/";
        }
        if(!model.containsAttribute("newBook")){
            model.addAttribute("newBook",new BookDto());
        }
        return "addNewBook";
    }

    @RequestMapping(value = "/addnewbook",method = RequestMethod.POST)
    public String saveBook(@Validated @ModelAttribute("newBook") BookDto bookDto,
                           BindingResult result,RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newBook",result);
            redirectAttributes.addFlashAttribute("newBook",bookDto);
            return "redirect:/addnewbook";
        }
        bookService.saveBook(bookDto);
        return "redirect:/";
    }

    @RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<AuthorDto> getAllAuthors(){
        List<AuthorDto> authorDtos = authorService.getAllAuthors();
        return authorDtos;
    }
    @RequestMapping(value = "/getAllGenres", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<GenreDto> getAllGenres(){
        List<GenreDto> genreDtos = genreService.getAllGenres();
        return genreDtos;
    }

}

package com.testbook.mvc.controllers;

import com.testbook.mvc.dto.AuthorDto;
import com.testbook.mvc.dto.BookDto;
import com.testbook.mvc.services.AuthorService;
import com.testbook.mvc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Alexey on 27.06.2017.
 */
@Controller
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }

    @RequestMapping(value = "/addauthor",method = RequestMethod.GET,name = "addNewAuthor")
    public String addBook(Model model){
        if(!model.containsAttribute("newAuthor")){
            model.addAttribute("newAuthor",new AuthorDto());
        }
        return "addAuthor";
    }


    @RequestMapping(value = "/addauthor",method = RequestMethod.POST)
    public String saveBook(@Valid @ModelAttribute("newAuthor") AuthorDto authorDto, BindingResult result,
                           RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newAuthor",result);
            redirectAttributes.addFlashAttribute("newAuthor",authorDto);
            return "redirect:/addauthor";
        }
        authorService.saveAuthor(authorDto);
        return "redirect:/addnewbook";
    }


}

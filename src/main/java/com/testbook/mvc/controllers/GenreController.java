package com.testbook.mvc.controllers;

import com.testbook.mvc.dto.AuthorDto;
import com.testbook.mvc.dto.GenreDto;
import com.testbook.mvc.services.GenreService;
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
public class GenreController {

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @RequestMapping(value = "/addgenre",method = RequestMethod.GET,name = "addNewGenre")
    public String addBook(Model model){
        if(!model.containsAttribute("newGenre")){
            model.addAttribute("newGenre",new AuthorDto());
        }
        return "addGenre";
    }


    @RequestMapping(value = "/addgenre",method = RequestMethod.POST)
    public String saveBook(@Valid @ModelAttribute("newGenre") GenreDto genreDto, BindingResult result,
                           RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            System.out.println("HAS ERRORS");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newGenre",result);
            redirectAttributes.addFlashAttribute("newGenre",genreDto);
            return "redirect:/addgenre";
        }
        genreService.saveGenre(genreDto);
        return "redirect:/addnewbook";
    }


}

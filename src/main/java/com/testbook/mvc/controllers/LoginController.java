package com.testbook.mvc.controllers;

import com.testbook.mvc.dto.AdminDto;
import com.testbook.mvc.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Alexey on 16.07.2017.
 */
@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, name = "login")
    public ModelAndView loginTo(Model model){
        ModelAndView modelAndView = new ModelAndView();
        if(!model.containsAttribute("admin")){
            modelAndView.addObject("admin",new AdminDto());
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLoginAdmin(@Valid @ModelAttribute("admin") AdminDto adminDto, BindingResult result,
                                  RedirectAttributes attributes, HttpSession session){
        if(result.hasErrors()){
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.admin",result);
            adminDto.setPassword("");
            attributes.addFlashAttribute("admin",adminDto);
            return "redirect:/login";
        }
        if(loginService.adminVerify(adminDto)){
            session.setAttribute("admin",adminDto);
            return "redirect:/addnewbook";
        }else {
            attributes.addFlashAttribute("error","Admin is not exist");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET, name = "logout")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}

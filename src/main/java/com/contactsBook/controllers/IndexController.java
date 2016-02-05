package com.contactsBook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 *
 */

@Controller
public class IndexController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirect(Locale locale, Model model) {
        return "redirect:/home";
    }

}

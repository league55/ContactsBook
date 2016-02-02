package com.contactsBook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 *
 */

@Controller
public class IndexController {


    @RequestMapping(value = "/ss", method = RequestMethod.GET)
    public ModelAndView home(Locale locale, Model model) {
        // (...)

        return new ModelAndView("index.ftl");
    }

}

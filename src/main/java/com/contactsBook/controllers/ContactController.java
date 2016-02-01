package com.contactsBook.controllers;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/")
    public ModelAndView getBlog(ModelAndView mv) {



        mv.addObject("title", "The contacts list");
        mv.addObject("message", "Here you can see contacts list <br/> Spring.");
        mv.addObject("contacts", contactService.getAllContacts());
        mv.setViewName("index");
        return mv;
    }
}

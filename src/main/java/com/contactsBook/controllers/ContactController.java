package com.contactsBook.controllers;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;




    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("title", "The contacts list");
        mv.addObject("message", "Here you can see contacts list <br/> Spring.");
        mv.addObject("contacts", contactService.getAllContacts());
        mv.setViewName("index");

        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contactForm") Contact contact, BindingResult result, Model model){

        System.out.println("--------"+result.getTarget().toString() +"-----------");
        this.contactService.addContact(contact);

        return "redirect:/index/";
    }




}

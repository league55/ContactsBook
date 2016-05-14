package com.contactsBook.controllers;

import com.contactsBook.models.Messege;
import com.contactsBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessegeController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/messegeSent", method = RequestMethod.POST)
    public String messegeSent(@ModelAttribute("messege") Messege messege, BindingResult result) {
        // System.out.println(messege.toString());

        // contactService.sendMessege(messege.getRecieverId(), messege.getSender(), messege.getContent());
        return "redirect:/view/"; //messege.getRecieverId();
    }


}

package com.contactsBook.controllers;

import com.contactsBook.entity.MappedMessege;
import com.contactsBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mixmax on 08.02.16.
 */

@Controller
public class MessegeController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/messegeSent", method = RequestMethod.POST)
    public String messegeSent(@ModelAttribute("messege") MappedMessege mappedMessege, BindingResult result) {
        // System.out.println(mappedMessege.toString());

        contactService.sendMessege(mappedMessege.getRecieverId(), mappedMessege.getSenderId(), mappedMessege.getContent());
        return "redirect:/view/" + mappedMessege.getRecieverId();
    }


}

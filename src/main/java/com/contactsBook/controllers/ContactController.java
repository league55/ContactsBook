package com.contactsBook.controllers;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 *
 */
@Controller
public class ContactController extends WebMvcConfigurerAdapter {
    @Autowired
    private ContactService contactService;

    @Autowired
    Validator contactValidator;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(Model model, @Valid MappedContact contact, BindingResult result) {

        if (result.hasErrors()) {
            for (ObjectError e : result.getAllErrors()) {
                System.out.println(e.getDefaultMessage());
            }

            model.addAttribute("contact", contact);
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("contacts", contactService.getAllContacts());
            model.addAttribute("title", "The contacts list");
            model.addAttribute("message", "Here you can see contacts list <br/> Spring.");
            return "/home";
        }
        return "result";
    }


    @RequestMapping(value = "/home")
    public String index(ModelAndView mv, Model m) {
        m.addAttribute("title", "The contacts list");
        m.addAttribute("message", "Here you can see contacts list <br/> Spring.");
        m.addAttribute("contacts", contactService.getAllContacts());
        mv.addObject("contacts", contactService.getAllContacts());
        m.addAttribute("contact", new MappedContact());
        return "/home";
    }

    @RequestMapping(value = "/doEdit/{Contact.tel}", method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("contact") @Valid Contact contact, @PathVariable("Contact.tel") String oldTel, ModelAndView mv) {
        System.out.println(oldTel + contact.toString());
        contactService.updateContact(oldTel, contact);
        mv.addObject("title", "The contacts list");
        mv.addObject("theContact", contact);
        mv.addObject("contacts", contactService.getAllContacts());
        mv.setViewName("home");

        return "redirect:/home";
    }
/*
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contactForm") @Valid Contact contact, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/home";
        }

        System.out.println("--------"+result.getTarget().toString() +"-----------");
        this.contactService.addContact(contact);

        return "redirect:redirect:/home/";
    }
*/


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result, Model model) {
        final BindException errors = new BindException(contact, "contact");


        if (result.hasErrors()) {
            System.out.println("errors---------");
            //validator.validate(contact, errors);
            return "redirect:/home";
        }

        System.out.println("--------" + result.getTarget().toString() + "-----------");
        this.contactService.addContact(contact);

        return "redirect:/home/";
    }


    @RequestMapping(value = "/delete/{tel}")
    public String deleteContact(@PathVariable("tel") String tel, Model model) {
        System.out.println("!");
        System.out.println(tel);
        System.out.println("--------  " + "  -----------");
        this.contactService.deleteContact(tel);

        return "redirect:/home";
    }

    @RequestMapping(value = "/edit/{tel}")
    public ModelAndView rederictContact(@PathVariable("tel") String tel, ModelAndView mv) {

        System.out.println("--------  " + "editing  -----------  " + tel + " ---");
        Contact contact = new Contact();
        if (contactService.getContact(tel) != null) {
            contact = contactService.getContact(tel);
        }
        mv.addObject("title", "The contacts list");
        mv.addObject("theContact", contact);
        mv.addObject("contacts", contactService.getAllContacts());
        mv.setViewName("contact");

        return mv;

    }




}

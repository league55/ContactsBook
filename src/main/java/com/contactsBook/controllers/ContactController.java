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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

/**
 *
 */
@Controller
public class ContactController extends WebMvcConfigurerAdapter {

    @Autowired
    private ContactService contactService;


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

        Contact c = new Contact(contact);

        System.out.println("--------" + result.getTarget().toString() + "-----------");
        this.contactService.addContact(c);
        return "redirect:/home";
    }


    @RequestMapping(value = "/home")
    public String index(ModelAndView mv, Model m) {
        List<Contact> allContacts = contactService.getAllContacts();
        m.addAttribute("title", "The contacts list");
        m.addAttribute("message", "Here you can see contacts list <br/> Spring.");
        m.addAttribute("contacts", allContacts);
        mv.addObject("contacts", allContacts);
        m.addAttribute("contact", new MappedContact());

/*

       contactService.sendMessege(1L,2L,"1");
       contactService.sendMessege(2L,1L,"2 - testing");
       contactService.sendMessege(1L,2L,"3");
       contactService.sendMessege(2L,1L,"4 - testing");
*/


        return "/home";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result, Model model) {
        final BindException errors = new BindException(contact, "contact");


        if (result.hasErrors()) {
            System.out.println("errors-in-form");
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
        MappedContact mappedContact = new MappedContact();
        mappedContact.setFirstName(contact.getFirstName());
        mappedContact.setLastName(contact.getLastName());
        mappedContact.setTel(contact.getTel());

        mv.addObject("title", "The contacts list");
        mv.addObject("theContact", mappedContact);
        mv.addObject("contacts", contactService.getAllContacts());
        mv.setViewName("editContact");

        return mv;

    }


    @RequestMapping(value = "/doEdit/{Contact.tel}", method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("contact") MappedContact contact, @PathVariable("Contact.tel") String oldTel, ModelAndView mv, BindingResult result) {


        System.out.println(oldTel + contact.toString());
        contactService.updateContact(oldTel, contact);
        mv.addObject("title", "The contacts list");
        mv.addObject("theContact", contact);
        mv.addObject("contacts", contactService.getAllContacts());
        mv.setViewName("home");

        return "redirect:/home";
    }




}

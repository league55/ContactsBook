package com.contactsBook.controllers;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import com.contactsBook.validator.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.*;

/**
 *
 */
@Controller
public class ContactController extends WebMvcConfigurerAdapter {

    private ContactService contactService;


    @Autowired
    public ContactController(ContactService contactService, ContactValidator contactValidator) {
        this.contactService = contactService;


    }

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

       /*String acceptorTel = allContacts.get(2).getTel();
       String senderTel = allContacts.get(3).getTel();
       contactService.sendMessege(acceptorTel,senderTel,"Hello");
       contactService.sendMessege(senderTel,acceptorTel,"testing");
       contactService.sendMessege(acceptorTel,senderTel,"How are you");
       contactService.sendMessege(senderTel,acceptorTel,"come on");
       contactService.sendMessege(acceptorTel,senderTel,"i'm fine, thx");
       contactService.sendMessege(acceptorTel,senderTel,"testing");

*/
        return "/home";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result, Model model) {
        final BindException errors = new BindException(contact, "contact");


        if (result.hasErrors()) {
            System.out.println("errors---------");

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

        if (result.hasErrors()) {
            System.out.println("errors---------");

            // return "redirect:/doEdit/{Contact.tel}";
        }
        System.out.println(oldTel + contact.toString());
        contactService.updateContact(oldTel, contact);
        mv.addObject("title", "The contacts list");
        mv.addObject("theContact", contact);
        mv.addObject("contacts", contactService.getAllContacts());
        mv.setViewName("home");

        return "redirect:/home";
    }

    @RequestMapping(value = "/view/{tel}")
    public ModelAndView viewContact(@PathVariable("tel") String tel, @RequestParam(value = "sender", defaultValue = "") String senderTel, ModelAndView mv, Model m) {


        Contact sender = new Contact();
        if (contactService.getContact(tel) != null) {
            sender = contactService.getContact(tel);
        }
        MappedMessege mm = new MappedMessege();
        MappedContact mappedSender = new MappedContact();
        mappedSender.setFirstName(sender.getFirstName());
        mappedSender.setLastName(sender.getLastName());
        mappedSender.setTel(sender.getTel());

        List<String> sendersTel = new ArrayList<String>();
        for (Contact c : contactService.getAllContacts()) {
            sendersTel.add(c.getTel());
        }

        if (sendersTel.contains(senderTel)) {
            SortedSet<MappedMessege> l = new TreeSet<MappedMessege>();
            List<MappedMessege> full = contactService.getConversation(tel, senderTel);
            full.addAll(contactService.getConversation(senderTel, tel));

            Collections.sort(full);
            mv.addObject("messeges", full);
        } else {
            mv.addObject("messeges", contactService.getAllMsg(tel));
        }


        mm.setSender(mappedSender);
        mv.addObject("sender", mappedSender);

        mv.addObject("sendersTel", sendersTel);
        mv.addObject("theContact", sender);
        mv.addObject("title", "Contact page");
        mv.addObject("contacts", contactService.getAllContacts());
        mv.addObject("messege", mm);
        mv.addObject("acceptorTel", "");
        mv.setViewName("viewContact");
        m.addAttribute("content", "");

        return mv;

    }


}

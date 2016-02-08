package com.contactsBook.controllers;

import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mixmax on 08.02.16.
 */

@Controller
public class PersonalPageController {
    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/view/{id}")
    public ModelAndView viewContact(@PathVariable("id") String recieverIdS, @ModelAttribute(value = "senderId") String senderIdS, ModelAndView mv, Model m) {


        Long recieverId = Long.parseLong(recieverIdS);
        List<Contact> senders = contactService.getAllContacts();
        senders.remove(contactService.getContact(recieverId));
        mv.addObject("senders", senders);

        //contactService.sendMessege(0L,1L,"Hello");
        //  contactService.sendMessege(1L,0L,"Hi");
        // contactService.sendMessege(0L,1L,"Whats up?");
        if (senderIdS.equals("")) {
            List<MappedMessege> messeges = contactService.getAllMsg(recieverId);
            Collections.sort(messeges);
            Collections.reverse(messeges);
            mv.addObject("messeges", messeges);
            List<String> names = new ArrayList<String>();
            List<Long> idList = new ArrayList<Long>();
            for (MappedMessege mm : messeges) {
                //      names.add(contactService.getContact(mm.getRecieverId()).getFirstName());
                //     idList.add(contactService.getContact(mm.getSenderId()).getId());

                System.out.println(mm.toString());
            }
            mv.addObject("names", names);
            mv.addObject("idList", idList);

        } else if (!senderIdS.equals("")) {
            Long senderId = Long.parseLong(senderIdS);

            List<MappedMessege> messeges = contactService.getConversation(recieverId, senderId);
            messeges.addAll(contactService.getConversation(senderId, recieverId));

            Collections.sort(messeges);
            Collections.reverse(messeges);

            mv.addObject("messeges", messeges);
            List<String> names = new ArrayList<String>(messeges.size());
            List<Long> idList = new ArrayList<Long>(messeges.size());
            for (MappedMessege mm : messeges) {
                names.add(contactService.getContact(mm.getSenderId()).getFirstName());
                idList.add(contactService.getContact(mm.getSenderId()).getId());
            }
            mv.addObject("names", names);
            mv.addObject("idList", idList);

        }

        MappedMessege mm = new MappedMessege();


        // mv.addObject("sendersTel", sendersTel);
        mv.addObject("theContact", contactService.getContact(recieverId));
        mv.addObject("title", "Contact page");
        mv.addObject("contacts", contactService.getAllContacts());
        // mv.addObject("messege", mm);
        mv.addObject("acceptorTel", "");
        mv.setViewName("viewContact");
        m.addAttribute("content", "");

        return mv;

    }
}

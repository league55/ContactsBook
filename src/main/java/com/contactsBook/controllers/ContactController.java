package com.contactsBook.controllers;

import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class ContactController extends WebMvcConfigurerAdapter {

    @Autowired
    private ContactService contactService;


    //-------------------Retrieve All Contacts
    @RequestMapping(value = "/contact/", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> listAllcontacts() {
        List<Contact> contacts = contactService.getAllContacts();
        if (contacts.isEmpty()) {
            return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }

    //-------------------Retrieve Single contact--------------------------------------------------------

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> getcontact(@PathVariable("id") long id) {
        System.out.println("Fetching contact with id " + id);
        Contact contact = contactService.getContact(id);
        if (contact == null) {
            System.out.println("contact with tel " + id + " not found");
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    //-------------------Create a contact--------------------------------------------------------

    @RequestMapping(value = "/contact/", method = RequestMethod.POST)
    public ResponseEntity<Void> createcontact(@RequestBody Contact contact, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating contact " + contact.getFirstName());

        contactService.addContact(contact);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contact/{tel}").buildAndExpand(contact.getTel()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

//------------------- Update a Contact --------------------------------------------------------

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(@PathVariable("id") long id, @RequestBody Contact contact) {
        System.out.println("Updating Contact " + id);

        Contact currentContact = contactService.getContact(id);


        if (currentContact == null) {
            System.out.println("Contact with id " + id + " not found");
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }

        currentContact.setFirstName(contact.getFirstName());
        currentContact.setLastName(contact.getLastName());
        currentContact.setTel(contact.getTel());
        currentContact.setId(contact.getId());

        contactService.updateContact(currentContact);
        return new ResponseEntity<Contact>(currentContact, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteContact(@PathVariable("id") Long id) {
        System.out.println("Fetching & Deleting Contact with id " + id);

        Contact contact = contactService.getContact(id);
        if (contact == null) {
            System.out.println("Unable to delete. Contact with id " + id + " not found");
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }

        contactService.deleteContact(id);
        return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
    }


    //------------------- Delete All Contacts --------------------------------------------------------

    @RequestMapping(value = "/contact/", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteAllContacts() {
        System.out.println("Deleting All Contacts");

        contactService.getAllContacts();
        return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
    }

}

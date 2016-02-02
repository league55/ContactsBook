package com.contactsBook.services;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;

import java.util.List;

public interface ContactService {

    void addContact(Contact contact);
    void deleteContact(MappedContact mappedContact);


    List<Contact> getAllContacts();


}
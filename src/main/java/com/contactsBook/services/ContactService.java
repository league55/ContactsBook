package com.contactsBook.services;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;

import java.util.List;

public interface ContactService {

    void addContact(Contact contact);
    void deleteContact(MappedContact mappedContact);

    MappedContact getContactByID(Long id);

    MappedContact getContactByTel(String tel);

    List<Contact> getAllContacts();


}
package com.contactsBook.services;

import com.contactsBook.models.Contact;

import java.util.List;

public interface ContactService {

    void addContact(Contact contact);

    void deleteContact(String tel);

    Contact getContact(String tel);

    void updateContact(String tel, Contact contact);
    List<Contact> getAllContacts();


}
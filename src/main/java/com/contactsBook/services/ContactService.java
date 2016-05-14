package com.contactsBook.services;

import com.contactsBook.models.Contact;
import com.contactsBook.models.Messege;

import java.util.List;

public interface ContactService {

    void addContact(Contact contact);

    void deleteContact(Long id);

    Contact getContact(String tel);

    Contact getContact(Long id);

    void updateContact(Contact contact);
    List<Contact> getAllContacts();

    String sendMessege(Contact reciever, Contact sender, String content);

    Messege deleteMessege(Long id);

    List<Messege> getConversation(Contact reciever, Contact sender);

    List<Messege> getAllMsg(Contact reciever);
}
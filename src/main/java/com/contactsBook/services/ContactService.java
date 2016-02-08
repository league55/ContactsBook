package com.contactsBook.services;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Contact;

import java.util.List;

public interface ContactService {

    void addContact(Contact contact);

    void deleteContact(String tel);

    Contact getContact(String tel);

    void updateContact(String tel, MappedContact contact);
    List<Contact> getAllContacts();

    String sendMessege(String tel1, String tel2, String content);

    List<MappedMessege> getConversation(String tel1, String tel2);

    List<MappedMessege> getAllMsg(String acceptorTel);
}
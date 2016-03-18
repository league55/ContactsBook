package com.contactsBook.services;

import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Contact;

import java.util.List;

public interface ContactService {

    void addContact(Contact contact);

    void deleteContact(Long id);

    Contact getContact(String tel);

    Contact getContact(Long id);

    void updateContact(Contact contact);
    List<Contact> getAllContacts();

    String sendMessege(Long acceptorId, Long senderId, String content);

    List<MappedMessege> getConversation(Long acceptorId, Long senderId);

    List<MappedMessege> getAllMsg(Long recieverId);
}
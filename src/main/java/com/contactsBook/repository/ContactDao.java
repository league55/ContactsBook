package com.contactsBook.repository;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;

import java.util.List;

public interface ContactDao {

    boolean saveContact(MappedContact mappedContact);

    MappedContact removeContact(String tel);

    void update(String oldTel, Contact mappedContact);

    MappedContact getContact(String tel);

    MappedContact getContact(Long id);

    List<MappedContact> getAllContacts();


}

package com.contactsBook.repository;

import com.contactsBook.entity.MappedContact;

import java.util.List;

public interface ContactDao {

    boolean saveContact(MappedContact mappedContact);

    MappedContact removeContact(Long id);

    void update(MappedContact mappedContact);

    MappedContact getContact(String tel);

    MappedContact getContact(Long id);

    List<MappedContact> getAllContacts();


}

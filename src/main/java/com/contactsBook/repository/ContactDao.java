package com.contactsBook.repository;

import com.contactsBook.entity.MappedContact;

import java.util.List;

public interface ContactDao {

    boolean saveContact(MappedContact mappedContact);

    MappedContact removeContact(String tel);

    void update(String oldTel, MappedContact mappedContact);

    MappedContact getContact(String tel);

    List<MappedContact> getAllContacts();


}

package com.contactsBook.repository;

import com.contactsBook.entity.MappedContact;

import java.util.List;

public interface ContactDao {

    public boolean saveContact(MappedContact mappedContact);

    public void removeContact(MappedContact contact);

    public MappedContact getContact(Long id);

    public MappedContact getContact(String tel);

    public List<MappedContact> getAllContacts();


}

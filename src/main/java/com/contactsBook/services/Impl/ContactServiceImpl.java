package com.contactsBook.services.Impl;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;
import com.contactsBook.models.Messege;
import com.contactsBook.repository.ContactDao;
import com.contactsBook.repository.MessegeDao;
import com.contactsBook.services.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {


    private static final Logger log = Logger.getLogger(ContactServiceImpl.class.getName());
    public static int currentContactsNum = 0;
    @Autowired
    private ContactDao contactDao;
    @Autowired
    private MessegeDao messegeDao;


    @Transactional
    public void addContact(Contact c) {
        MappedContact mappedContact = new MappedContact();

        mappedContact.setFirstName(c.getFirstName());
        mappedContact.setLastName(c.getLastName());
        mappedContact.setTel(c.getTel());

        contactDao.saveContact(mappedContact);

    }



    @Transactional
    public void deleteContact(Long id) {
        contactDao.removeContact(id);
    }


    public Contact getContact(String tel) {
        Contact c = new Contact();
        MappedContact mp = contactDao.getContact(tel);

        c.setTel(mp.getTel());
        c.setLastName(mp.getLastName());
        c.setFirstName(mp.getFirstName());

        return c;
    }

    @Transactional
    public Contact getContact(Long id) {

        MappedContact mp = contactDao.getContact(id);
        Contact c = new Contact(mp);
        return c;
    }

    @Transactional
    public void updateContact(Contact c) {
        MappedContact mappedContact = new MappedContact();

        mappedContact.setFirstName(c.getFirstName());
        mappedContact.setLastName(c.getLastName());
        mappedContact.setTel(c.getTel());
        mappedContact.setId(c.getId());

        contactDao.update(mappedContact);
    }

    @Transactional(readOnly = true)
    public List<Contact> getAllContacts() {

        List<MappedContact> mappedContacts = contactDao.getAllContacts();
        List<Contact> contacts = new ArrayList<Contact>(mappedContacts.size());
        for (MappedContact mappedContact : mappedContacts) {
            Contact contact = new Contact(mappedContact);

            System.out.println(contact.toString());
            contacts.add(contact);
        }
        return contacts;
    }

    @Transactional
    public String sendMessege(Contact reciever, Contact sender, String content) {
        Messege m = new Messege();
        m.setSender(sender);
        m.setReciever(reciever);
        m.setTime(new Date());
        m.setContent(content);

        messegeDao.storeMessege(m);
        return m.getContent() + " " + m.getTime();
    }

    public Messege deleteMessege(Long id) {
        return messegeDao.deleteMessege(id);
    }

    @Transactional(readOnly = true)
    public List<Messege> getConversation(Contact reciever, Contact sender) {
        return messegeDao.getConversation(reciever, sender);
    }

    @Transactional(readOnly = true)
    public List<Messege> getAllMsg(Contact reciever) {
        return messegeDao.getAllMsg(reciever);
    }


}
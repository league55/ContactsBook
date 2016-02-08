package com.contactsBook.services.Impl;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.entity.MappedMessege;
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

/**
 * Created by mixmax on 05.12.15.
 */
@Service
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactDao contactDao;

    @Autowired
    private MessegeDao messegeDao;


    private static final Logger log = Logger.getLogger(ContactServiceImpl.class.getName());
    public static int currentContactsNum = 0;



    private int MAX_CONTACTS_NUM; //should be final
    private List<MappedContact> base = new ArrayList<MappedContact>();



    @Transactional
    public void addContact(Contact c) {
        MappedContact mappedContact = new MappedContact();


        mappedContact.setFirstName(c.getFirstName());
        mappedContact.setLastName(c.getLastName());
        mappedContact.setTel(c.getTel());
        contactDao.saveContact(mappedContact);

    }



    @Transactional
    public void deleteContact(String tel) {
        contactDao.removeContact(tel);
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
    public void updateContact(String oldTel, MappedContact c) {
       /* MappedContact mappedContact = new MappedContact();
        mappedContact.setFirstName(c.getFirstName());
        mappedContact.setLastName(c.getLastName());
        mappedContact.setTel(c.getTel());*/
        contactDao.update(oldTel, c);
    }

  //  @Transactional(readOnly = true)
    public List<Contact> getAllContacts() {

        List<MappedContact> mappedContacts = contactDao.getAllContacts();
        List<Contact> contacts = new ArrayList<Contact>(mappedContacts.size());
        for (MappedContact mappedContact : mappedContacts) {
            Contact contact = new Contact();

            contact.setFirstName(mappedContact.getFirstName());
            contact.setLastName(mappedContact.getLastName());
            contact.setTel(mappedContact.getTel());
            System.out.println(contact.toString());
            contacts.add(contact);
        }
        return contacts;
    }



    public String toString() {
        Object[] array = base.toArray();

        String s = "";
        for (Object c : array) {
            s = s + c.toString() + "\n";
        }
        return s;
    }

    public String sendMessege(String acceptorTel, String senderTel, String content) {
        Messege m = new Messege();
        m.setSender(getContact(senderTel));
        m.setAcceptor(getContact(acceptorTel));
        m.setTime(new Date());
        m.setContent(content);

        messegeDao.storeMessege(m);
        return m.getContent();
    }

    public List<MappedMessege> getConversation(String acceptorTel, String senderTel) {


        List<MappedMessege> toReturn = messegeDao.getConversation(acceptorTel, senderTel);

        return toReturn;
    }

    public List<MappedMessege> getAllMsg(String acceptorTel) {
        return messegeDao.getAllMsg(acceptorTel);
    }
    public void setMAX_CONTACTS_NUM(int MAX_CONTACTS_NUM) {
        this.MAX_CONTACTS_NUM = MAX_CONTACTS_NUM;
    }

    public List<MappedContact> getBase() {
        return base;
    }

    public void setBase(List<MappedContact> base) {
        this.base = base;
    }

}
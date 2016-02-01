package com.contactsBook.repository;

import com.contactsBook.entity.MappedContact;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ContactRepository implements ContactDao {
    private static final Logger log = Logger.getLogger(ContactRepository.class.getName());


    @PersistenceContext
    EntityManager em;


    @Transactional
    public boolean saveContact(MappedContact mappedContact) {
        em.persist(mappedContact);
        return true;
    }


    public void removeContact(MappedContact mappedContact) {
        System.out.println("Removing " + mappedContact.toString());
            em.remove(mappedContact);
     }


    public MappedContact getContact(Long id) {
        MappedContact c = em.find(MappedContact.class, id);
        return c;
    }


    public MappedContact getContact(String tel) {

        MappedContact c = new MappedContact();
        TypedQuery<MappedContact> query = em.createQuery("Select c FROM Contact c where c.tel = " + tel, MappedContact.class);
        c = query.getResultList().get(0);

        return c;
    }

    @Transactional
    public List<MappedContact> getAllContacts() {
        saveContact(new MappedContact("maixm","sadf","1123"));


        return em.createQuery("SELECT mappedContact FROM MappedContact mappedContact").getResultList();
    }


}
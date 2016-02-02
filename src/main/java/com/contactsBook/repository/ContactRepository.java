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
   // private static final Logger log = Logger.getLogger(ContactRepository.class.getName());


    @PersistenceContext
    EntityManager em;



    public boolean saveContact(MappedContact mappedContact) {

     //   em.persist(em.merge(mappedContact));
        em.persist((mappedContact));


        return true;
    }


    public void removeContact(MappedContact mappedContact) {
        System.out.println("Removing " + mappedContact.toString());
            em.remove(mappedContact);
     }




    @Transactional
    public List<MappedContact> getAllContacts() {
       return em.createQuery("SELECT mappedContact FROM MappedContact mappedContact").getResultList();
    }


}
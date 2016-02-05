package com.contactsBook.repository;

import com.contactsBook.entity.MappedContact;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContactRepository implements ContactDao {
   // private static final Logger log = Logger.getLogger(ContactRepository.class.getName());


    @PersistenceContext
    EntityManager em;



    public boolean saveContact(MappedContact mappedContact) {
        em.persist((mappedContact));

        return true;
    }


    public MappedContact removeContact(String tel) {
        MappedContact mp;
        try {
            mp = (MappedContact) em.createQuery("SELECT m FROM MappedContact m where m.tel=:tel").setParameter("tel", tel).getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            mp = null;
            System.out.println("ACCOUNT WASN'T FOUND");
        } catch (NonUniqueResultException e) {

            List<MappedContact> ll = em.createQuery("SELECT m FROM MappedContact m where m.tel=:tel").setParameter("tel", tel).getResultList();

            for (MappedContact mappedContact : ll) {
                em.remove(mappedContact);
                em.flush();
                System.out.println(mappedContact.toString() + "removed");
            }
            mp = null;
        }

        if (mp != null) {
            em.remove(mp);
            System.out.println("Removing " + mp.toString());
        }
        return mp;
    }

    public void update(String oldTel, MappedContact mappedContact) {
        String newFirstName = mappedContact.getFirstName();
        String newLastName = mappedContact.getLastName();
        String newTel = mappedContact.getTel();
        MappedContact oldContact = getContact(oldTel);
        if ((newFirstName != null) && (!newFirstName.trim().equals(""))) oldContact.setFirstName(newFirstName);
        if ((newLastName != null) && (!newLastName.trim().equals(""))) oldContact.setLastName(newLastName);
        if ((newTel != null) && (newTel.trim().length() >= 9)) oldContact.setTel(newTel);
        em.merge(oldContact);
    }

    public MappedContact getContact(String tel) {
        MappedContact mp;
        try {
            mp = (MappedContact) em.createQuery("SELECT m FROM MappedContact m where m.tel=:tel").setParameter("tel", tel).getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            mp = null;
            System.out.println("ACCOUNT WASN'T FOUND");
        } catch (NonUniqueResultException e) {

            List<MappedContact> ll = em.createQuery("SELECT m FROM MappedContact m where m.tel=:tel").setParameter("tel", tel).getResultList();

            mp = ll.get(0);
        }
        return mp;
    }




    @Transactional
    public List<MappedContact> getAllContacts() {


        return em.createQuery("SELECT mappedContact FROM MappedContact mappedContact").getResultList();
    }


}
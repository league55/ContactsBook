package com.contactsBook.repository.Impl;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.repository.ContactDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {
    // private static final Logger log = Logger.getLogger(ContactDaoImpl.class.getName());


    @PersistenceContext
    EntityManager em;



    public boolean saveContact(MappedContact mappedContact) {
        em.persist(mappedContact);
        return true;
    }


    public MappedContact removeContact(Long id) {
        MappedContact mp;
        try {
            mp = (MappedContact) em.createQuery("SELECT m FROM MappedContact m where m.id=:id").setParameter("id", id).getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            mp = null;
            System.out.println("ACCOUNT WASN'T FOUND");
        } catch (NonUniqueResultException e) {

            List<MappedContact> ll = em.createQuery("SELECT m FROM MappedContact m where m.id=:id").setParameter("id", id).getResultList();

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

    public void update(MappedContact mappedContact) {
        String newFirstName = mappedContact.getFirstName();
        String newLastName = mappedContact.getLastName();
        String newTel = mappedContact.getTel() + "";
        Long id = mappedContact.getContact_id();

        MappedContact oldContact = getContact(id);
        if ((newFirstName != null) && (!newFirstName.trim().equals(""))) oldContact.setFirstName(newFirstName);
        if ((newLastName != null) && (!newLastName.trim().equals(""))) oldContact.setLastName(newLastName);
        if ((newTel != null) && (newTel.trim().length() >= 5)) oldContact.setTel(newTel);
        em.merge(oldContact);
    }

    public MappedContact getContact(String tel) {
        MappedContact mp;
        System.out.println(tel);
        try {
            mp = (MappedContact) em.createQuery("SELECT m FROM MappedContact m where m.tel=:tel").setParameter("tel", tel).getSingleResult();
            System.out.println(mp.toString());
        } catch (EmptyResultDataAccessException e) {
            mp = null;
            System.out.println("ACCOUNT WASN'T FOUND");
        } catch (NonUniqueResultException e) {

            List<MappedContact> ll = em.createQuery("SELECT m FROM MappedContact m where m.tel=:tel").setParameter("tel", tel).getResultList();

            mp = ll.get(0);
        }
        return mp;
    }

    public MappedContact getContact(Long id) {
        MappedContact mp;
        try {
            mp = (MappedContact) em.createQuery("SELECT m FROM MappedContact m where m.id=:id").setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            mp = null;
            System.out.println("ACCOUNT WASN'T FOUND");
        } catch (NonUniqueResultException e) {

            List<MappedContact> ll = em.createQuery("SELECT m FROM MappedContact m where m.id=:id").setParameter("id", id).getResultList();

            mp = ll.get(0);
        }
        return mp;
    }


    public List<MappedContact> getAllContacts() {
        return em.createQuery("SELECT mappedContact FROM MappedContact mappedContact").getResultList();
    }


}
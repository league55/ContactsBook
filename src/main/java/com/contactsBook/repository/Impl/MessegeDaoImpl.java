package com.contactsBook.repository.Impl;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Contact;
import com.contactsBook.models.Messege;
import com.contactsBook.repository.ContactDao;
import com.contactsBook.repository.MessegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessegeDaoImpl implements MessegeDao {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ContactDao contactDao;



    public void storeMessege(Messege m) {
        MappedMessege mm = new MappedMessege();

        MappedContact sender = contactToMappedContact(m.getSender());
        MappedContact reciever = contactToMappedContact(m.getReciever());

        mm.setTime(m.getTime());
        mm.setContent(m.getContent());
        mm.setReciever(reciever);
        mm.setSender(sender);

        em.persist(mm);

    }


    public List<Messege> getConversation(Contact reciever, Contact sender) {

        Query q = em.createQuery("SELECT mappedMessege FROM MappedMessege mappedMessege WHERE mappedMessege.reciever=:reciever AND mappedMessege.sender=:sender");
        q.setParameter("reciever", reciever);
        q.setParameter("sender", sender);

        List<Messege> messeges = new ArrayList<Messege>();
        for (Object mm : q.getResultList()) {
            messeges.add(new Messege((MappedMessege) mm));
        }

        return messeges;
    }

    public List<Messege> getAllMsg(Contact reciever) {
        MappedContact mappedReciever = contactToMappedContact(reciever);
        //TODO: must use reciever;
        Query q = em.createQuery("SELECT mappedMessege FROM MappedMessege mappedMessege");

        List<Messege> messeges = new ArrayList<Messege>();
        for (Object mm : q.getResultList()) {
            messeges.add(new Messege((MappedMessege) mm));
        }

        return messeges;
    }

    public Messege deleteMessege(Long id) {
        MappedMessege mappedMessege;

        mappedMessege = (MappedMessege) em.createQuery("SELECT mappedMessege " +
                "FROM MappedMessege mappedMessege where mappedMessege.id=" + id)
                .setParameter("id", id)
                .getSingleResult();
        em.remove(mappedMessege);

        return new Messege(mappedMessege);
    }


    private MappedContact contactToMappedContact(Contact c) {
        MappedContact mc = new MappedContact();
        mc.setFirstName(c.getFirstName());
        mc.setLastName(c.getLastName());
        mc.setTel(c.getTel());
        mc.setId(c.getId());
        return mc;
    }
}


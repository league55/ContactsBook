package com.contactsBook.repository.Impl;

import com.contactsBook.entity.MappedContact;
import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Messege;
import com.contactsBook.repository.ContactDao;
import com.contactsBook.repository.MessegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mixmax on 06.02.16.
 */
@Repository
public class MessegeDaoImpl implements MessegeDao {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ContactDao contactDao;


    @Transactional
    public void storeMessege(Messege m) {
        MappedMessege mm = new MappedMessege();
        MappedContact sender, acceptor;

        acceptor = contactDao.getContact(m.getAcceptor().getTel());
        sender = contactDao.getContact(m.getSender().getTel());
        mm.setAcceptor(acceptor);
        mm.setTime(m.getTime());
        mm.setSender(sender);
        mm.setContent(m.getContent());
        em.persist(mm);
    }

    @SuppressWarnings("JpaQlInspection")
    @Transactional
    public List<MappedMessege> getConversation(String acceptorTel, String senderTel) {
        MappedContact sender, acceptor;

        sender = contactDao.getContact(senderTel);
        acceptor = contactDao.getContact(acceptorTel);
        Query q = em.createQuery("SELECT mappedMessege FROM MappedMessege mappedMessege WHERE mappedMessege.acceptor=:acceptor AND mappedMessege.sender=:sender");
        q.setParameter("acceptor", acceptor);
        q.setParameter("sender", sender);
        return q.getResultList();
    }

    public List<MappedMessege> getAllMsg(String acceptorTel) {
        MappedContact acceptor = contactDao.getContact(acceptorTel);

        Query q = em.createQuery("SELECT mappedMessege FROM MappedMessege mappedMessege WHERE mappedMessege.acceptor=:acceptor");
        q.setParameter("acceptor", acceptor);
        return q.getResultList();
    }
}


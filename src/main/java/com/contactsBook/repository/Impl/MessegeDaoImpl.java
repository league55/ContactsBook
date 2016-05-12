package com.contactsBook.repository.Impl;

import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Messege;
import com.contactsBook.repository.ContactDao;
import com.contactsBook.repository.MessegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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



    public void storeMessege(Messege m) {
        MappedMessege mm = new MappedMessege();

        mm.setTime(m.getTime());
        mm.setContent(m.getContent());
        mm.setRecieverId(m.getRecieverID());
        mm.setSenderId(m.getSenderId());
        em.persist(mm);
    }


    public List<MappedMessege> getConversation(Long recieverId, Long senderId) {

        Query q = em.createQuery("SELECT mappedMessege FROM MappedMessege mappedMessege WHERE mappedMessege.recieverId=:recieverid AND mappedMessege.senderId=:senderid");
        q.setParameter("recieverid", recieverId);
        q.setParameter("senderid", senderId);

        return q.getResultList();
    }

    public List<MappedMessege> getAllMsg(Long recieverId) {
        Query q = em.createQuery("SELECT mappedMessege FROM MappedMessege mappedMessege");
 
        return q.getResultList();
    }


}


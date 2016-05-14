package com.contactsBook.repository;

import com.contactsBook.models.Contact;
import com.contactsBook.models.Messege;

import java.util.List;


public interface MessegeDao {

    void storeMessege(Messege m);

    List<Messege> getConversation(Contact reciever, Contact sender);

    List<Messege> getAllMsg(Contact reciever);


    Messege deleteMessege(Long id);
}

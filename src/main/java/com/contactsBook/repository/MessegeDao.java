package com.contactsBook.repository;

import com.contactsBook.entity.MappedMessege;
import com.contactsBook.models.Messege;

import java.util.List;


public interface MessegeDao {

    void storeMessege(Messege m);

    List<MappedMessege> getConversation(Long recieverId, Long senderId);

    List<MappedMessege> getAllMsg(Long recieverId);


}

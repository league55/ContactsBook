package com.contactsBook.repository;
/*
import com.contactsBook.entity.MappedContact;
import com.contactsBook.services.ContactService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertEquals;



   @DirtiesContext @Ignore
   @RunWith(SpringJUnit4ClassRunner.class)
   @ContextConfiguration(classes = com.contactsBook.configuration.AppConfig.class)
   @WebAppConfiguration
public class TestGetContact {
    @Resource
    private EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @Resource
    private ContactService cs;

    private MappedContact contact = new MappedContact(2,"Name","LastName", "Tel");

    @Before
    public void setUp() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
        cs.addContact(contact);

    }

    @Test

    public void gettingContactById(){
        assertEquals("Must return contact with id=2 ",cs.getContactByID(5).getContact_id(),2);
    }




}
     */
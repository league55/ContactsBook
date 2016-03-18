package com.contactsBook.repository;

import com.contactsBook.models.Contact;
import com.contactsBook.services.ContactService;
import com.contactsBook.services.Impl.ContactServiceImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TestContactRepository extends TestCase {

    @InjectMocks
    ContactService cs = new ContactServiceImpl();

    @Mock
    Contact contact;

    @Before
    public void setUp() throws Exception {

        contact = new Contact();
        contact.setFirstName("TestName");
        contact.setLastName("TestLast");
        contact.setTel("TestTel");


    }

    @Test
    public void testSaveContact() throws Exception {
        cs.addContact(contact);
        Contact contact2 = cs.getContact(contact.getTel());
        System.out.println(contact2);
        assertEquals(contact2, contact);
    }


}

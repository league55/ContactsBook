package Impl;

import com.contactsBook.models.Contact;
import com.contactsBook.models.Messege;
import com.contactsBook.repository.MessegeDao;
import com.contactsBook.services.ContactService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class MessegeServiceTest {

    @Mock
    MessegeDao messegeDao;

    @InjectMocks
    ContactService contactService;

    @Spy
    List<Messege> messeges;
    @Spy
    List<Contact> contacts;


    @Before
    public void before() throws Exception {
        MockitoAnnotations.initMocks(this);
        contacts = getContactList();
        messeges = getMessegesList();


    }

    private List<Messege> getMessegesList() {
        List<Messege> messeges = new ArrayList<Messege>();
        Messege m1 = new Messege();
        m1.setId(1L);
        m1.setContent("Test MEssege 1");
        m1.setReciever(contacts.get(0));
        m1.setSender(contacts.get(1));

        Messege m2 = new Messege();
        m1.setId(2L);
        m1.setContent("Test MEssege 2");
        m1.setReciever(contacts.get(1));
        m1.setSender(contacts.get(0));

        return messeges;
    }

    private List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<Contact>();
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        c1.setFirstName("contact ");
        c1.setLastName("1");

        c2.setFirstName("contact");
        c2.setLastName("2");

        contacts.add(c1);
        contacts.add(c2);
        return contacts;
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testStoreMessege() throws Exception {

        doNothing().when(messegeDao).storeMessege(any(Messege.class));
        contactService.sendMessege(any(Messege.class));
        verify(messegeDao, atLeastOnce()).storeMessege(any(Messege.class));
    }

    /**
     * Method: getConversation(Contact reciever, Contact sender)
     */
    @Test
    public void testGetConversation() throws Exception {
        when(contactService.getConversation(any(Contact.class), any(Contact.class))).thenReturn(messeges);
        contactService.getConversation(contacts.get(0), contacts.get(1));
        verify(messegeDao, atLeastOnce()).getConversation(contacts.get(0), contacts.get(1));

        //check arguments order
        verify(messegeDao, never()).getConversation(contacts.get(1), contacts.get(0));

    }


    @Test
    public void testGetAllMsg() throws Exception {
        when(contactService.getAllMsg(any(Contact.class))).thenReturn(messeges);
        contactService.getAllMsg(contacts.get(0));
        verify(messegeDao, atLeastOnce()).getAllMsg(contacts.get(0));
    }


    @Test
    public void testDeleteMessege() throws Exception {
        when(contactService.deleteMessege(any(Long.class))).thenReturn(messeges.get(0));
        contactService.deleteMessege(messeges.get(0).getId());
        verify(messegeDao, atLeastOnce()).deleteMessege(contacts.get(0).getId());
    }


    @Test
    public void testContactToMappedContact() throws Exception {

//TODO: test

    }


}

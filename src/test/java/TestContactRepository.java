import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;
import com.contactsBook.repository.ContactDao;
import com.contactsBook.services.Impl.ContactServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class TestContactRepository {
    @InjectMocks
    ContactServiceImpl contactService;
    @Mock
    ContactDao contactDao;


    @Spy
    List<Contact> contacts = new ArrayList<Contact>();

    Contact cnt;
    MappedContact mc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        contacts = getContactList();

        cnt = contacts.get(0);

        mc = new MappedContact();
        mc.setContact_id(cnt.getId());
        mc.setFirstName(cnt.getFirstName());
        mc.setLastName(cnt.getLastName());
        mc.setTel(cnt.getTel());
    }

    @Test
    public void findById() {

        when(contactDao.getContact(anyLong())).thenReturn(mc);
        assertEquals(contactService.getContact(cnt.getId()), cnt);
    }

    @Test
    public void saveEmployee() {
        contactService.addContact(cnt);
        verify(contactDao, atLeastOnce()).saveContact(any(MappedContact.class));
    }

    @Test
    public void updateContact() {
        contactService.updateContact(cnt);
        verify(contactDao, atLeastOnce()).update(any(MappedContact.class));
    }

    @Test
    public void deleteContact() {
        when(contactDao.removeContact(anyLong())).thenReturn(mc);
        contactService.deleteContact(anyLong());
        verify(contactDao, atLeastOnce()).removeContact(anyLong());
    }


    public List<Contact> getContactList() {
        Contact c1 = new Contact();
        c1.setId(1L);
        c1.setFirstName("Axel");
        c1.setLastName("LastName1");
        c1.setTel("0635980041");

        Contact c2 = new Contact();
        c2.setId(2L);
        c2.setFirstName("Jeremy");
        c2.setLastName("LastName2");
        c2.setTel("0500543774");
        contacts.add(c1);
        contacts.add(c2);
        return contacts;
    }
}

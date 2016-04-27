import com.contactsBook.entity.MappedContact;
import com.contactsBook.models.Contact;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by mixmax on 20.04.16.
 */

@RunWith(JUnitParamsRunner.class)
public class ContactTest {
    MappedContact mappedContact;
    Contact contact;

    String firstName = "fn";
    String lastName = "ln";
    String tel = "01";
    long id = 0L;

    @Before
    public void setUp() {

        mappedContact = new MappedContact();
        mappedContact.setFirstName(firstName);
        mappedContact.setLastName(lastName);
        mappedContact.setTel(tel);
        mappedContact.setContact_id(id);

        contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setTel(tel);
        contact.setId(id);
    }

    @Test
    public void constructorShouldSetValuesFromMappedContactProperly() {
        Contact contact2 = new Contact(mappedContact);
        assertEquals(contact, contact2);
    }
}

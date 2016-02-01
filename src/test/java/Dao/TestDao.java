package Dao;

/*
@RunWith(MockitoJUnitRunner.class)
public class TestDao {

    ContactServiceImpl mockedContactService;
   ContactBase mockedContactBase;
    MappedContact contact;
    ArrayList<MappedContact> base;


    @Before
    public void setUp() {
        mockedContactService = mock(ContactServiceImpl.class);
        mockedContactBase = mock(ContactBase.class);
        base = new ArrayList<MappedContact>();
        contact = new MappedContact(3, "A", "B", "020202");

        when(mockedContactBase.getBase()).thenReturn(base);
        when(mockedContactBase.getAllContacts()).thenReturn(base);
        when(mockedContactService.getAllContacts()).thenReturn(base);
    }

    @Test
    public void testDaoToString() {
        mockedContactBase.addContact(contact);
        assertNotNull(mockedContactBase.getAllContacts());
        mockedContactBase.deleteContact(contact);
        assertTrue(mockedContactBase.getAllContacts().isEmpty());
        ArrayList<MappedContact> temp = base;
        temp.add(contact);
        assertEquals(mockedContactBase.addContact(contact), temp);

    }


}
*/

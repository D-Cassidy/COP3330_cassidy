import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactListTest {
    @Test
    void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        assertEquals(1, list.contacts.size());
    }
    @Test
    void editingItemsFailsWithAllBlankValues() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        list.editContactInfo(0,"", "", "", "");
        assertEquals("First Name", list.contacts.get(0).firstName);
        assertEquals("Last Name", list.contacts.get(0).lastName);
        assertEquals("123-456-7890", list.contacts.get(0).phoneNumber);
        assertEquals("first@website.com", list.contacts.get(0).emailAddress);
    }
    @Test
    void editingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        list.editContactInfo(69,"Firsty", "Lasty", "", "");
        assertEquals("First Name", list.contacts.get(0).firstName);
        assertEquals("Last Name", list.contacts.get(0).lastName);
        assertEquals("123-456-7890", list.contacts.get(0).phoneNumber);
        assertEquals("first@website.com", list.contacts.get(0).emailAddress);
    }
    @Test
    void editingSucceedsWithBlankFirstName() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        list.editContactInfo(0,"", "Lasty", "123-456-7890", "first@website.com");
        assertEquals("", list.contacts.get(0).firstName);
        assertEquals("Lasty", list.contacts.get(0).lastName);
        assertEquals("123-456-7890", list.contacts.get(0).phoneNumber);
        assertEquals("first@website.com", list.contacts.get(0).emailAddress);
    }
    @Test
    void editingSucceedsWithBlankLastName() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        list.editContactInfo(0,"Firsty", "", "123-456-7890", "first@website.com");
        assertEquals("Firsty", list.contacts.get(0).firstName);
        assertEquals("", list.contacts.get(0).lastName);
        assertEquals("123-456-7890", list.contacts.get(0).phoneNumber);
        assertEquals("first@website.com", list.contacts.get(0).emailAddress);
    }
    @Test
    void editingSucceedsWithBlankPhone() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        list.editContactInfo(0,"Firsty", "Lasty", "", "first@website.com");
        assertEquals("Firsty", list.contacts.get(0).firstName);
        assertEquals("Lasty", list.contacts.get(0).lastName);
        assertEquals("", list.contacts.get(0).phoneNumber);
        assertEquals("first@website.com", list.contacts.get(0).emailAddress);
    }
    @Test
    void editingSucceedsWithNonBlankValues() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        list.editContactInfo(0,"Firsty", "Lasty", "567-890-1324", "first@website.com");
        assertEquals("Firsty", list.contacts.get(0).firstName);
        assertEquals("Lasty", list.contacts.get(0).lastName);
        assertEquals("567-890-1324", list.contacts.get(0).phoneNumber);
        assertEquals("first@website.com", list.contacts.get(0).emailAddress);
    }
    @Test
    void newListIsEmpty() {
        ContactList list = new ContactList();
        assertEquals(0, list.contacts.size());
    }
    @Test
    void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        assertEquals(1, list.contacts.size());
        list.removeContact(0);
        assertEquals(0, list.contacts.size());
    }
    @Test
    void removingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        list.addContact("First Name", "Last Name", "123-456-7890", "first@website.com");
        assertEquals(1, list.contacts.size());
        list.removeContact(13);
        assertEquals(1, list.contacts.size());
    }
}

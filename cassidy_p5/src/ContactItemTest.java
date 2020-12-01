import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ContactItemTest {
    @Test
    void creationFailsWithAllBlankValues() {
        ContactItem item = new ContactItem("", "", "", "");
        assertEquals(null, item.firstName);
        assertEquals(null, item.lastName);
        assertEquals(null, item.phoneNumber);
        assertEquals(null, item.emailAddress);
    }
    @Test
    void creationSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "");
        assertEquals("John", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("", item.emailAddress);
    }
    @Test
    void creationSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("", "Smith", "123-456-7890", "johnsmith@gmail.com");
        assertEquals("", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void creationSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("John", "", "123-456-7890", "johnsmith@gmail.com");
        assertEquals("John", item.firstName);
        assertEquals("", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void creationSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("John", "Smith", "", "johnsmith@gmail.com");
        assertEquals("John", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void creationSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "johnsmith@gmail.com");
        assertEquals("John", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void creationFailsWithInvalidEamil() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "thisisaninvalidemail");
        assertEquals(null, item.firstName);
        assertEquals(null, item.lastName);
        assertEquals(null, item.phoneNumber);
        assertEquals(null, item.emailAddress);
    }
    @Test
    void creationFailsWithInvalidPhoneNumber() {
        ContactItem item = new ContactItem("John", "Smith", "12456790", "johnsmith@gmail.com");
        assertEquals(null, item.firstName);
        assertEquals(null, item.lastName);
        assertEquals(null, item.phoneNumber);
        assertEquals(null, item.emailAddress);
    }
    @Test
    void editingFailsWithAllBlankValues() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "johnsmith@gmail.com");
        item.editContactItem("", "", "", "");
        assertEquals("John", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void editingSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "johnsmith@gmail.com");
        item.editContactItem("John", "Smith", "123-456-7890", "");
        assertEquals("John", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("", item.emailAddress);
    }
    @Test
    void editingSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "johnsmith@gmail.com");
        item.editContactItem("", "Smith", "123-456-7890", "johnsmith@gmail.com");
        assertEquals("", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void editingSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "johnsmith@gmail.com");
        item.editContactItem("John", "", "123-456-7890", "johnsmith@gmail.com");
        assertEquals("John", item.firstName);
        assertEquals("", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void editingSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "johnsmith@gmail.com");
        item.editContactItem("John", "Smith", "", "johnsmith@gmail.com");
        assertEquals("John", item.firstName);
        assertEquals("Smith", item.lastName);
        assertEquals("", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
    @Test
    void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("John", "Smith", "123-456-7890", "johnsmith@gmail.com");
        item.editContactItem("Johnny", "Smithy", "123-456-7890", "johnsmith@gmail.com");
        assertEquals("Johnny", item.firstName);
        assertEquals("Smithy", item.lastName);
        assertEquals("123-456-7890", item.phoneNumber);
        assertEquals("johnsmith@gmail.com", item.emailAddress);
    }
}

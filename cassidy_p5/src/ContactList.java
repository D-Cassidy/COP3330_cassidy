import java.util.ArrayList;

public class ContactList {
    ArrayList<ContactItem> contacts = new ArrayList<>();

    // DISPLAY FUNCTION
    public void displayContactList() {
        int i = 0;
        for (ContactItem contact : this.contacts) {
            System.out.printf("%d) Name: %s %s\n", i, contact.firstName, contact.lastName);
            System.out.printf("Phone: %s\n", contact.phoneNumber);
            System.out.printf("Email: %s\n", contact.emailAddress);
            i++;
        }
        System.out.println();
    }

    // LIST FUNCTIONS
    public void addContact(String firstName, String lastName, String phoneNumber, String emailAddress) {
        ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
        if(contact.firstName != null && contact.lastName != null && contact.phoneNumber != null && contact.emailAddress != null) {
            this.contacts.add(new ContactItem(firstName, lastName, phoneNumber, emailAddress));
        }
    }

    public void editContactInfo(int index, String firstName, String lastName, String phoneNumber, String emailAddress) {
        try {
            ContactItem contact = contacts.get(index);
            contact.editContactItem(firstName, lastName, phoneNumber, emailAddress);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }

    public void removeContact(int index) {
        try {
            this.contacts.remove(index);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }
}

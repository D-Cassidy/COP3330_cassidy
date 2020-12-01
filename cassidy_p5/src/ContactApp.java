import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    private static final Scanner scnr = new Scanner(System.in);

    // MENU FUNCTIONS
    public static void contactAppMainMenu() {
        while(true) {
            displayMainMenuText();

            try {
                int input = getMenuInput(3);

                if (input == 1) {
                    ContactList list = new ContactList();
                    System.out.println("new contact list has been created");
                    listOperationMenu(list);
                } else if (input == 2) {
                    ContactList list = loadExistingList();
                    listOperationMenu(list);
                } else if (input == 3) {
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("You must enter a valid integer");
                scnr.nextLine();
            }
        }
    }
    private static void listOperationMenu(ContactList list) {
        while(true) {
            displayListOperationMenuText();

            try {
                int input = getMenuInput(6);

                if (input == 1) {
                    displayContacts(list);
                } else if (input == 2) {
                    addContact(list);
                } else if (input == 3) {
                    editContact(list);
                } else if (input == 4) {
                    removeContact(list);
                } else if (input == 5) {
                    saveCurrentList(list);
                } else if (input == 6) {
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("You must enter a valid integer");
                scnr.nextLine();
            }
        }
    }

    private static ContactList loadExistingList() {
        String filename;
        scnr.nextLine();
        System.out.print("Enter the filename to load: ");
        filename = scnr.nextLine();

        ContactList list = new ContactList();
        try(Scanner input = new Scanner(Paths.get(filename))) {
            while (input.hasNext()) {
                String[] info = input.nextLine().split(";");
                list.addContact(info[0], info[1], info[2], info[3]);
            }
        } catch(IOException e) {
            System.out.println("An error occurred");
        }

        System.out.println("contact list has been loaded");
        return list;
    }

    // LIST OPERATION FUNCTIONS
    private static void displayContacts(ContactList list) {
        System.out.println("Current Contacts");
        System.out.println("----------------\n");
        list.displayContactList();
    }
    private static void addContact(ContactList list) {
        String firstName, lastName, phoneNumber, emailAddress;

        scnr.nextLine();
        System.out.print("First name: ");
        firstName = scnr.nextLine();

        System.out.print("Last name: ");
        lastName = scnr.nextLine();

        System.out.print("Phone number (xxx-xxx-xxxx): ");
        phoneNumber = scnr.nextLine();

        System.out.print("Email address (x@y.z): ");
        emailAddress = scnr.nextLine();

        list.addContact(firstName, lastName, phoneNumber, emailAddress);
    }
    private static void editContact(ContactList list) {
        int index;
        String firstName, lastName, phoneNumber, emailAddress;

        scnr.nextLine();
        displayContacts(list);
        System.out.print("Which contact will you edit? ");
        index = scnr.nextInt();

        scnr.nextLine();
        System.out.printf("Enter a new first name for contact %d: ", index);
        firstName = scnr.nextLine();

        System.out.printf("Enter a new last name for contact %d:", index);
        lastName = scnr.nextLine();

        System.out.printf("Enter a new phone number (xxx-xxx-xxxx) for contact %d: ", index);
        phoneNumber = scnr.nextLine();

        System.out.printf("Enter a new email address (x@y.z) for contact %d: ", index);
        emailAddress = scnr.nextLine();

        list.editContactInfo(index, firstName, lastName, phoneNumber, emailAddress);
    }
    private static void removeContact(ContactList list) {
        int index;

        scnr.nextLine();
        displayContacts(list);
        System.out.print("Which task will you remove? ");
        index = scnr.nextInt();
        list.removeContact(index);
    }
    private static void saveCurrentList(ContactList list) {
        String filename;
        scnr.nextLine();
        System.out.print("Enter the filename to save as: ");
        filename = scnr.nextLine();

        try (Formatter output = new Formatter(filename)) {
            for (ContactItem contact : list.contacts) {
                output.format("%s;%s;%s;%s\n", contact.firstName, contact.lastName, contact.phoneNumber, contact.emailAddress);
            }
        } catch(FileNotFoundException e) {
            System.out.println("An error occurred");
        }

        System.out.println("task list has been saved");
    }

    // HELPER FUNCTIONS
    private static int getMenuInput(int menuSize) {
        int input = scnr.nextInt();
        if(input < 1 || input > menuSize) {
            System.out.printf("You must enter an integer between 1 and %d\n", menuSize);
        }
        return input;
    }
    private static void displayMainMenuText() {
        System.out.println("Main Menu");
        System.out.println("---------\n");

        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
    }
    private static void displayListOperationMenuText() {
        System.out.println("\nList Operation Menu");
        System.out.println("-------------------\n");

        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
    }
}

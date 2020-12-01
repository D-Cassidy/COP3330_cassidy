import java.time.DateTimeException;
import java.time.LocalDate;

public class ContactItem {
    String firstName;
    String lastName;
    String phoneNumber;
    String emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        // Fail if all blank
        if(firstName.length() == 0 &&
                lastName.length() == 0 &&
                phoneNumber.length() == 0 &&
                emailAddress.length() == 0) {
            System.out.println("Contact cannot have all blank values");
            return;
        }
        // Fail if bad formats on phone or email
        if(!isValidPhoneNumber(phoneNumber) || !isValidEmailAddress(emailAddress)) {
            return;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    public void editContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        // Fail if all blank
        if(firstName.length() == 0 &&
                lastName.length() == 0 &&
                phoneNumber.length() == 0 &&
                emailAddress.length() == 0) {
            System.out.println("Contact cannot have all blank values");
            return;
        }
        // Fail if bad formats on phone or email
        if(!isValidPhoneNumber(phoneNumber) || !isValidEmailAddress(emailAddress)) {
            return;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    private static Boolean isValidPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 0) {
            return true;
        }
        boolean valid = true;
        for(int i = 0; i < phoneNumber.length(); i++) {
            if(i == 3 || i == 7) {
                if(phoneNumber.charAt(i) != "-".charAt(0)) {
                    valid = false;
                }
            }
            else if(!Character.isDigit(phoneNumber.charAt(i))) {
                valid = false;
            }
        }
        if(!valid) {
            System.out.println("Phone number must be either blank or formatted as (xxx-xxx-xxxx)");
        }
        return valid;
    }
    private static Boolean isValidEmailAddress(String emailAddress) {
        if(emailAddress.length() == 0) {
            return true;
        }
        String[] temp = emailAddress.split("@");
        if(temp.length != 2) {
            System.out.println("Email address must be either blank or formatted as (x@y.z)");
            return false;
        }
        temp = temp[1].split("\\.");
        if(temp.length != 2) {
            System.out.println("Email address must be either blank or formatted as (x@y.z)");
            return false;
        }
        return true;
    }
}

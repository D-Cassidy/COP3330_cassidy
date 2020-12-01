import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static final Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            displayApplicationSelectionText();
            try {
                int input = getMenuInput(3);
                if (input == 1) {
                    TaskApp.taskAppMainMenu();
                } else if (input == 2) {
                    ContactApp.contactAppMainMenu();
                } else if (input == 3) {
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("You must enter a valid integer");
                scnr.nextLine();
            }
        }
    }

    private static int getMenuInput(int menuSize) {
        int input = scnr.nextInt();
        if(input < 1 || input > menuSize) {
            System.out.printf("You must enter an integer between 1 and %d\n", menuSize);
        }
        return input;
    }
    private static void displayApplicationSelectionText() {
        System.out.println("Select Your Application");
        System.out.println("-----------------------\n");

        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
    }
}

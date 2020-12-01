import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
    private static final Scanner scnr = new Scanner(System.in);

    // MENU FUNCTIONS
    public static void taskAppMainMenu() {
        while(true) {
            displayMainMenuText();

            try {
                int input = getMenuInput(3);

                if (input == 1) {
                    TaskList list = new TaskList();
                    System.out.println("new task list has been created");
                    listOperationMenu(list);
                } else if (input == 2) {
                    TaskList list = loadExistingList();
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
    private static void listOperationMenu(TaskList list) {
        while(true) {
            displayListOperationMenuText();

            try {
                int input = getMenuInput(8);

                if (input == 1) {
                    displayTasks(list);
                } else if (input == 2) {
                    addTask(list);
                } else if (input == 3) {
                    editTask(list);
                } else if (input == 4) {
                    removeTask(list);
                } else if (input == 5) {
                    completeTask(list);
                } else if (input == 6) {
                    unmarkCompleteTask(list);
                } else if (input == 7) {
                    saveCurrentList(list);
                } else if (input == 8) {
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("You must enter a valid integer");
                scnr.nextLine();
            }
        }
    }

    private static TaskList loadExistingList() {
        String filename;
        scnr.nextLine();
        System.out.print("Enter the filename to load: ");
        filename = scnr.nextLine();

        TaskList list = new TaskList();
        try(Scanner input = new Scanner(Paths.get(filename))) {
            while (input.hasNext()) {
                String[] info = input.nextLine().split(";");
                list.addTask(info[1], info[2], info[0], Boolean.parseBoolean(info[3]));
            }
        } catch(IOException e) {
            System.out.println("An error occurred");
        }

        System.out.println("task list has been loaded");
        return list;
    }

    // LIST OPERATION OPTIONS
    private static void displayTasks(TaskList list) {
        System.out.println("Current Tasks");
        System.out.println("-------------\n");
        list.displayTaskList();
    }
    private static void addTask(TaskList list) {
        String title, desc, date;

        scnr.nextLine();
        System.out.print("Task title: ");
        title = scnr.nextLine();

        System.out.print("Task description: ");
        desc = scnr.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        date = scnr.nextLine();

        list.addTask(title, desc, date, false);
    }
    private static void editTask(TaskList list) {
        int index;
        String title, desc, date;

        scnr.nextLine();
        displayTasks(list);
        System.out.print("Which task will you edit? ");
        index = scnr.nextInt();

        scnr.nextLine();
        System.out.print("Task title: ");
        title = scnr.nextLine();

        System.out.print("Task description: ");
        desc = scnr.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        date = scnr.nextLine();

        list.editTaskInfo(index, title, desc, date);
    }
    private static void removeTask(TaskList list) {
        int index;

        scnr.nextLine();
        displayTasks(list);
        System.out.print("Which task will you remove? ");
        index = scnr.nextInt();
        list.removeTask(index);
    }
    private static void completeTask(TaskList list) {
        int index;

        scnr.nextLine();
        displayUncompletedTasks(list);
        System.out.print("Which task will you mark as completed? ");
        index = scnr.nextInt();
        list.markTaskAsComplete(index);
    }
    private static void unmarkCompleteTask(TaskList list) {
        int index;

        scnr.nextLine();
        displayCompletedTasks(list);
        System.out.print("Which task will you unmark as completed? ");
        index = scnr.nextInt();
        list.unmarkTaskAsComplete(index);
    }
    private static void saveCurrentList(TaskList list) {
        String filename;
        scnr.nextLine();
        System.out.print("Enter the filename to save as: ");
        filename = scnr.nextLine();

        try (Formatter output = new Formatter(filename)) {
            for (TaskItem task : list.tasks) {
                output.format("%s;%s;%s;%s\n", task.dueDate, task.title, task.desc, task.completed);
            }
        } catch(FileNotFoundException e) {
            System.out.println("An error occurred");
        }

        System.out.println("task list has been saved");
    }

    // MENU HELPERS
    private static int getMenuInput(int menuSize) {
        int input = scnr.nextInt();
        if(input < 1 || input > menuSize) {
            System.out.printf("You must enter an integer between 1 and %d\n", menuSize);
        }
        return input;
    }
    private static void displayUncompletedTasks(TaskList list) {
        System.out.println("Uncompleted Tasks");
        System.out.println("-----------------\n");
        list.displayUncompletedTasks();
    }
    private static void displayCompletedTasks(TaskList list) {
        System.out.println("Completed Tasks");
        System.out.println("--------------\n");
        list.displayCompletedTasks();
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
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
    }
}

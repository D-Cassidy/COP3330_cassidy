import java.time.DateTimeException;
import java.time.LocalDate;

public class TaskItem {
    String title;
    String desc;
    String dueDate;
    boolean completed;

    public TaskItem(String title, String desc, String dateStr, Boolean completed) {
        try {
            if(title.length() < 1) {
                System.out.println("WARNING: Title must be 1 or more characters; Task not created");
                return;
            }
            String[] dateInfo = dateStr.split("-");
            LocalDate date = LocalDate.of(Integer.parseInt(dateInfo[0]),
                    Integer.parseInt(dateInfo[1]),
                    Integer.parseInt(dateInfo[2]));

            this.title = title;
            this.desc = desc;
            this.dueDate = date.toString();
            this.completed = completed;
        } catch(DateTimeException | NumberFormatException e) {
            System.out.println("WARNING: Date entered must be valid date in format YYYY-MM-DD; Task not created");
        }
    }

    public void setTitleTo(String title) {
        if(title.length() < 1) {
            System.out.println("WARNING: Title must be 1 or more characters; Title not changed");
            return;
        }
        this.title = title;
    }
    public void setDescTo(String desc) {
        this.desc = desc;
    }
    public void setDateTo(String dateStr) {
        try {
            String[] dateInfo = dateStr.split("-");
            LocalDate date = LocalDate.of(Integer.parseInt(dateInfo[0]),
                    Integer.parseInt(dateInfo[1]),
                    Integer.parseInt(dateInfo[2]));

            this.dueDate = date.toString();
        } catch(DateTimeException | IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("WARNING: Date entered must be valid date in format YYYY-MM-DD; Date not changed");
        }
    }
    public void markAsComplete() {
        this.completed = true;
    }
    public void unmarkAsComplete() {
        this.completed = false;
    }
}

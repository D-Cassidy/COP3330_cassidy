import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskItemTest {
    @Test
    void creatingTaskItemFailsWithInvalidDueDate() {
        String date = "2020-14-45";
        TaskItem item = new TaskItem("Date test", "", date, false);
        assertEquals(null, item.dueDate);
    }
    @Test
    void creatingTaskItemFailsWithInvalidTitle() {
        String title = "";
        TaskItem item = new TaskItem(title, "Title test", "2020-10-15", false);
        assertEquals(null, item.title);
    }
    @Test
    void creatingTaskItemSucceedsWithValidDueDate() {
        String date = "2020-10-15";
        TaskItem item = new TaskItem("Date test", "", date, false);
        assertEquals("2020-10-15", item.dueDate);
    }
    @Test
    void creatingTaskItemSucceedsWithValidTitle() {
        String title = "Test title";
        TaskItem item = new TaskItem(title, "Title test", "2020-10-15", false);
        assertEquals("Test title", item.title);
    }
    @Test
    void settingTaskItemDueDateFailsWithInvalidDate() {
        String date = "2020-10-15";
        TaskItem item = new TaskItem("Date test", "", date, false);
        item.setDateTo("3520-13-45");
        assertEquals("2020-10-15", item.dueDate);
    }
    @Test
    void settingTaskItemDueDateSucceedsWithValidDate() {
        String date = "2020-10-15";
        TaskItem item = new TaskItem("Date test", "", date, false);
        item.setDateTo("2020-10-16");
        assertEquals("2020-10-16", item.dueDate);
    }
    @Test
    void settingTaskItemTitleFailsWithInvalidTitle() {
        String title = "Test title";
        TaskItem item = new TaskItem(title, "Title test", "2020-10-15", false);
        item.setTitleTo("");
        assertEquals("Test title", item.title);
    }
    @Test
    void settingTaskItemTitleSucceedsWithValidTitle() {
        String title = "Test title";
        TaskItem item = new TaskItem(title, "Title test", "2020-10-15", false);
        item.setTitleTo("New Test title");
        assertEquals("New Test title", item.title);
    }
}

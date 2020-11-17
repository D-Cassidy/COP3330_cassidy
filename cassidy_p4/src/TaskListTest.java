import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskListTest {
    @Test
    void addingTaskItemsIncreasesSize() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);

        assertEquals(1, list.tasks.size());
    }
    @Test
    void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.markTaskAsComplete(0);

        assertEquals(true, list.tasks.get(0).completed);
    }
    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.markTaskAsComplete(3);
    }
    @Test
    void editingTaskItemChangesValues() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.editTaskInfo(0,"New title", "New desc", "2020-10-16");

        TaskItem task = list.tasks.get(0);
        assertEquals("New title", task.title);
        assertEquals("New desc", task.desc);
        assertEquals("2020-10-16", task.dueDate);
    }
    @Test
    void editingTaskItemDescriptionChangesValue() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.editTaskDescription(0, "New desc");

        TaskItem task = list.tasks.get(0);
        assertEquals("New desc", task.desc);
    }
    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.editTaskDescription(69, "New desc");
    }
    @Test
    void editingTaskItemDueDateChangesValue() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.editTaskDueDate(0, "2020-10-16");

        TaskItem task = list.tasks.get(0);
        assertEquals("2020-10-16", task.dueDate);
    }
    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.editTaskDueDate(70, "2020-10-16");
    }
    @Test
    void editingTaskItemTitleChangesValue() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.editTaskTitle(0, "New title");

        TaskItem task = list.tasks.get(0);
        assertEquals("New title", task.title);
    }
    @Test
    void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.editTaskTitle(71, "New title");
    }
    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.getTaskDescription(72);
    }
    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        assertEquals("Test desc", list.getTaskDescription(0));
    }
    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.getTaskDueDate(73);
    }
    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        assertEquals("2020-10-15", list.getTaskDueDate(0));
    }
    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.getTaskTitle(74);
    }
    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        assertEquals("Test title", list.getTaskTitle(0));
    }
    @Test
    void newTaskListIsEmpty() {
        TaskList list = new TaskList();
        assertEquals(0, list.tasks.size());
    }
    @Test
    void removingTaskItemsDecreasesSize() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.removeTask(0);
        assertEquals(0, list.tasks.size());
    }
    @Test
    void removingTaskItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.removeTask(75);
    }
    @Test
    void savedTaskListCanBeLoaded() {

    }
    @Test
    void uncompletingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.markTaskAsComplete(0);
        assertEquals(true, list.tasks.get(0).completed);

        list.unmarkTaskAsComplete(0);
        assertEquals(false, list.tasks.get(0).completed);
    }
    @Test
    void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.addTask("Test title", "Test desc", "2020-10-15", false);
        list.markTaskAsComplete(0);
        assertEquals(true, list.tasks.get(0).completed);

        list.unmarkTaskAsComplete(76);
    }
}

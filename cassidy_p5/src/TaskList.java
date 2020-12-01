import java.util.ArrayList;

public class TaskList {
    ArrayList<TaskItem> tasks = new ArrayList<>();

    // DISPLAY FUNCTIONS
    public void displayTaskList() {
        int i = 0;
        for (TaskItem task : this.tasks) {
            if(task.completed) {
                System.out.printf("%d) *** [%s] %s: %s\n", i, task.dueDate, task.title, task.desc);
            }
            else {
                System.out.printf("%d) [%s] %s: %s\n", i, task.dueDate, task.title, task.desc);
            }
            i++;
        }
        System.out.println();
    }
    public void displayCompletedTasks() {
        int i = 0;
        for (TaskItem task : this.tasks) {
            if(task.completed) {
                System.out.printf("%d) [%s] %s: %s\n", i, task.dueDate, task.title, task.desc);
            }
            i++;
        }
        System.out.println();
    }
    public void displayUncompletedTasks() {
        int i = 0;
        for (TaskItem task : this.tasks) {
            if(!task.completed) {
                System.out.printf("%d) [%s] %s: %s\n", i, task.dueDate, task.title, task.desc);
            }
            i++;
        }
        System.out.println();
    }

    // LIST FUNCTIONS
    public void addTask(String title, String desc, String date, Boolean completed) {
        TaskItem task = new TaskItem(title, desc, date, false);
        if(task.title != null && task.desc != null && task.dueDate !=null) {
            this.tasks.add(new TaskItem(title, desc, date, completed));
        }
    }
    public void removeTask(int index) {
        try {
            this.tasks.remove(index);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }

    public void markTaskAsComplete(int index) {
        try {
            TaskItem task = tasks.get(index);
            task.markAsComplete();
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }
    public void unmarkTaskAsComplete(int index) {
        try {
            TaskItem task = tasks.get(index);
            task.unmarkAsComplete();
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }

    // EDITS
    public void editTaskInfo(int index, String title, String desc, String date) {
        try {
            editTaskTitle(index, title);
            editTaskDescription(index, desc);
            editTaskDueDate(index, date);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }
    public void editTaskTitle(int index, String title) {
        try {
            TaskItem task = tasks.get(index);
            task.setTitleTo(title);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }
    public void editTaskDescription(int index, String desc) {
        try {
            TaskItem task = tasks.get(index);
            task.setDescTo(desc);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }
    public void editTaskDueDate(int index, String date) {
        try {
            TaskItem task = tasks.get(index);
            task.setDateTo(date);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
        }
    }

    // GETS
    public String getTaskTitle(int index) {
        try {
            TaskItem task = tasks.get(index);
            return task.title;
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
            return "";
        }
    }
    public String getTaskDescription(int index) {
        try {
            TaskItem task = tasks.get(index);
            return task.desc;
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
            return "";
        }
    }
    public String getTaskDueDate(int index) {
        try {
            TaskItem task = tasks.get(index);
            return task.dueDate;
        } catch(IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task index");
            return "";
        }
    }
}

package TaskPlanner.models;

import java.util.ArrayList;
import java.util.List;

public class Sprint {
    String name;
    List<Task> tasks = new ArrayList<>();

    public Sprint(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        task.sprint = this.name;
        tasks.add(task);
    }

    public void displaySprintStatus() {
        System.out.println("Sprint Status for " + name + ":");
        System.out.println("● On Track Tasks:");
        tasks.stream().filter(task -> !task.isDelayed()).forEach(task -> System.out.println("○ " + task.title));
        System.out.println("● Delayed Tasks:");
        tasks.stream().filter(Task::isDelayed).forEach(task -> System.out.println("○ " + task.title));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

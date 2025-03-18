package TaskPlanner.repositories;

import TaskPlanner.models.Sprint;
import TaskPlanner.models.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {
    Map<String, Task> tasks = new HashMap<>();
    Map<String, Sprint> sprints = new HashMap<>();

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, Task> tasks) {
        this.tasks = tasks;
    }

    public Map<String, Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Map<String, Sprint> sprints) {
        this.sprints = sprints;
    }

    public void addTask(Task task) {
        tasks.put(task.getTitle(), task);
    }

    public void createSprint(String name) {
        sprints.put(name, new Sprint(name));
    }

    public void addTaskToSprint(String sprintName, String taskTitle) {
        if (sprints.containsKey(sprintName) && tasks.containsKey(taskTitle)) {
            sprints.get(sprintName).addTask(tasks.get(taskTitle));
        }
    }
}

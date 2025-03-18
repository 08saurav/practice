package TaskPlanner.controllers;

import TaskPlanner.services.TaskService;
import TaskPlanner.models.Impact;
import java.time.LocalDate;

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public String createFeature(String title, String creator, String assignee, LocalDate dueDate, String summary, Impact impact) {
        if (title == null || title.isEmpty() || creator == null || creator.isEmpty()) {
            return "Error: Title and creator are required.";
        }

        try {
            taskService.createFeature(title, creator, assignee, dueDate, summary, impact);
            return "Feature task created successfully!";
        } catch (Exception e) {
            return "Error creating task: " + e.getMessage();
        }
    }
}

package TaskPlanner.services;

import TaskPlanner.models.Bug;
import TaskPlanner.models.Feature;
import TaskPlanner.models.Impact;
import TaskPlanner.models.Story;
import TaskPlanner.repositories.TaskRepository;

import java.time.LocalDate;
import java.util.Comparator;

public class TaskService {
    TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void displayTasksByUser(String assignee) {
        System.out.println("Tasks assigned to " + assignee + ":");
        repository.getTasks().values().stream()
                .filter(task -> task.getAssignee().equals(assignee))
                .sorted(Comparator.comparing(task -> task.getType()))
                .forEach(task -> {
                    System.out.println("● " + task.getType() + ":");
                    System.out.println("○ Task: " + task.getTitle() + ", " + task.getStatus() + ", " + task.getDueDate() + ", " + task.getType() + ", " + (task instanceof Bug ? ((Bug) task).getSeverity() : "") + ", " + (task.getSprint() != null ? task.getSprint() : "No Sprint"));
                    if (task instanceof Story story) {
                        System.out.println("○ SubTasks:");
                        story.getSubTasks().forEach(subTask -> System.out.println("■ " + subTask.getTitle()));
                    }
                });
    }

    public void createFeature(String title, String creator, String assignee, LocalDate dueDate, String summary, Impact impact) {
        Feature feature = new Feature(title, creator, assignee, dueDate, summary, impact);
        repository.addTask(feature);
    }
}

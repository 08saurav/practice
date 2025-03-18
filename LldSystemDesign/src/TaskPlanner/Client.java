package TaskPlanner;

import TaskPlanner.controllers.TaskController;
import TaskPlanner.models.Bug;
import TaskPlanner.models.Impact;
import TaskPlanner.models.Story;
import TaskPlanner.models.SubTask;
import TaskPlanner.repositories.TaskRepository;
import TaskPlanner.services.TaskService;
import TaskPlanner.models.Severity;
import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {
        TaskRepository repo = new TaskRepository();
        TaskService taskService = new TaskService(repo);

        // Creating Tasks
        Bug bug = new Bug("Fix MySQL Issue", "Ryan", "Ryan", LocalDate.of(2024, 12, 14), Severity.P0);
        Story story = new Story("Create a Microservice", "Amy", "Ryan", LocalDate.of(2024, 12, 18), "Develop a microservice");
        story.addSubTask(new SubTask("Development"));
        story.addSubTask(new SubTask("Unit Test"));
        story.addSubTask(new SubTask("Integration Test"));

        repo.addTask(bug);
        repo.addTask(story);

        // Creating Sprint
        repo.createSprint("Sprint-1");
        repo.addTaskToSprint("Sprint-1", "Fix MySQL Issue");
        repo.addTaskToSprint("Sprint-1", "Create a Microservice");

        // Display Assigned Tasks
        taskService.displayTasksByUser("Ryan");

        // Display Sprint Status
        repo.getSprints().get("Sprint-1").displaySprintStatus();
    }
}

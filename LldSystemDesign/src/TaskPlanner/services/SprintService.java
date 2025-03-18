package TaskPlanner.services;

import TaskPlanner.repositories.TaskRepository;

public class SprintService {
    TaskRepository repository;

    public SprintService(TaskRepository repository) {
        this.repository = repository;
    }

    public void createSprint(String name) {
        repository.createSprint(name);
    }

    public void addTaskToSprint(String sprintName, String taskTitle) {
        repository.addTaskToSprint(sprintName, taskTitle);
    }
}

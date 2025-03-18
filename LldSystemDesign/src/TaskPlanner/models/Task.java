package TaskPlanner.models;

import java.time.LocalDate;

public abstract class Task {
    String title;
    String creator;
    String assignee;
    TaskStatus status;
    TaskType type;
    LocalDate dueDate;
    String sprint;

    public Task(String title, String creator, String assignee, TaskStatus status, TaskType type, LocalDate dueDate) {
        this.title = title;
        this.creator = creator;
        this.assignee = assignee;
        this.status = status;
        this.type = type;
        this.dueDate = dueDate;
    }

    public void changeStatus(TaskStatus newStatus) {
        this.status = newStatus;
    }

    public void changeAssignee(String newAssignee) {
        this.assignee = newAssignee;
    }

    public boolean isDelayed() {
        return !status.equals(TaskStatus.COMPLETED) && LocalDate.now().isAfter(dueDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }
}

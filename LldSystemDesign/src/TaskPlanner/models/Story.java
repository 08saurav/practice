package TaskPlanner.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Story Task
public class Story extends Task {
    String storySummary;
    List<SubTask> subTasks = new ArrayList<>();

    public String getStorySummary() {
        return storySummary;
    }

    public void setStorySummary(String storySummary) {
        this.storySummary = storySummary;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public Story(String title, String creator, String assignee, LocalDate dueDate, String storySummary) {
        super(title, creator, assignee, TaskStatus.OPEN, TaskType.STORY, dueDate);
        this.storySummary = storySummary;
    }

    public void addSubTask(SubTask subTask) {
        if (this.status != TaskStatus.COMPLETED) {
            subTasks.add(subTask);
        }
    }
}

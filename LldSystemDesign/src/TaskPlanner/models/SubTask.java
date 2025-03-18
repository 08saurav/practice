package TaskPlanner.models;

// SubTask Model
public class SubTask {
    String title;
    TaskStatus status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public SubTask(String title) {
        this.title = title;
        this.status = TaskStatus.OPEN;
    }
}

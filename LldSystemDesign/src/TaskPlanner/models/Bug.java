package TaskPlanner.models;

import java.time.LocalDate;

public class Bug extends Task {
    Severity severity;

    public Bug(String title, String creator, String assignee, LocalDate dueDate, Severity severity) {
        super(title, creator, assignee, TaskStatus.OPEN, TaskType.BUG, dueDate);
        this.severity = severity;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
}

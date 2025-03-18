package TaskPlanner.models;

import java.time.LocalDate;

public class Feature extends Task {
    String featureSummary;
    Impact impact;

    public Feature(String title, String creator, String assignee, LocalDate dueDate, String featureSummary, Impact impact) {
        super(title, creator, assignee, TaskStatus.OPEN, TaskType.FEATURE, dueDate);
        this.featureSummary = featureSummary;
        this.impact = impact;
    }

    public String getFeatureSummary() {
        return featureSummary;
    }

    public void setFeatureSummary(String featureSummary) {
        this.featureSummary = featureSummary;
    }

    public Impact getImpact() {
        return impact;
    }

    public void setImpact(Impact impact) {
        this.impact = impact;
    }
}

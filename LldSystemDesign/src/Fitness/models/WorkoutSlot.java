package Fitness.models;

public class WorkoutSlot {
    int startTime, endTime, capacity;
    String startDate, endDate;

    public WorkoutSlot(int startTime, int endTime, int capacity, String startDate, String endDate) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

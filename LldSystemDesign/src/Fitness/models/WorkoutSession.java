package Fitness.models;

import java.time.LocalDate;

public class WorkoutSession {
    String center;
    String workoutType;
    int startTime;
    int endTime;
    int capacity;
    LocalDate startDate;
    LocalDate endDate;
    int availableSeats;

    public WorkoutSession(String center, String workoutType, int startTime, int endTime, int capacity, LocalDate startDate, LocalDate endDate) {
        this.center = center;
        this.workoutType = workoutType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.availableSeats = capacity;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

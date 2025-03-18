package Fitness.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Center {
    String name;
    Map<String, List<WorkoutSlot>> workoutSlots = new HashMap<>();

    public Center(String name) {
        this.name = name;
    }

    public void addWorkout(String workoutType, int startTime, int endTime, int capacity, String startDate, String endDate) {
        workoutSlots.putIfAbsent(workoutType, new ArrayList<>());
        workoutSlots.get(workoutType).add(new WorkoutSlot(startTime, endTime, capacity, startDate, endDate));
    }

    public void viewWorkoutAvailability(String workoutType, String date) {
        if (workoutSlots.containsKey(workoutType)) {
            for (WorkoutSlot slot : workoutSlots.get(workoutType)) {
                System.out.println(name + " - " + workoutType + " - " + slot.startTime + " to " + slot.endTime + " - " + slot.capacity + " seats available");
            }
        }
    }

    public void bookSession(String userName, String workoutType, int startTime, int endTime, String date) {
        if (workoutSlots.containsKey(workoutType)) {
            for (WorkoutSlot slot : workoutSlots.get(workoutType)) {
                if (slot.startTime == startTime && slot.endTime == endTime && slot.capacity > 0) {
                    slot.capacity--;
                    System.out.println("Booking confirmed for " + userName + " at " + name + " for " + workoutType);
                    return;
                }
            }
        }
        System.out.println("Booking failed. No available slots.");
    }

    public void viewSchedule(String userName, String date, String workoutType) {
        System.out.println(userName + "'s Schedule on " + date + ": " + name + " - " + workoutType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<WorkoutSlot>> getWorkoutSlots() {
        return workoutSlots;
    }

    public void setWorkoutSlots(Map<String, List<WorkoutSlot>> workoutSlots) {
        this.workoutSlots = workoutSlots;
    }
}

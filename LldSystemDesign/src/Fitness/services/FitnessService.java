package Fitness.services;

import Fitness.models.Center;
import Fitness.models.User;

import java.util.HashMap;
import java.util.Map;

public class FitnessService {
    private final Map<String, Center> centers = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    public void registerUser(String name, String email, String location) {
        users.put(email, new User(name, email, location));
        System.out.println("User registered: " + name);
    }

    public void addWorkout(String centerName, String workoutType, int startTime, int endTime, int capacity, String startDate, String endDate) {
        centers.putIfAbsent(centerName, new Center(centerName));
        centers.get(centerName).addWorkout(workoutType, startTime, endTime, capacity, startDate, endDate);
    }

    public void viewWorkoutSlotAvailability(String workoutType, String date) {
        for (Center center : centers.values()) {
            center.viewWorkoutAvailability(workoutType, date);
        }
    }

    public void bookSession(String userName, String centerName, String workoutType, int startTime, int endTime, String date) {
        if (centers.containsKey(centerName)) {
            centers.get(centerName).bookSession(userName, workoutType, startTime, endTime, date);
        }
    }

    public void viewSchedule(String userName, String date, String centerName, String workoutType) {
        if (centers.containsKey(centerName)) {
            centers.get(centerName).viewSchedule(userName, date, workoutType);
        }
    }
}

package Fitness.services;

import Fitness.models.WorkoutSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkoutService {
    List<WorkoutSession> sessions = new ArrayList<>();

    public void addWorkout(String center, String workoutType, int startTime, int endTime, int capacity, String startDate, String endDate) {
        sessions.add(new WorkoutSession(center, workoutType, startTime, endTime, capacity, LocalDate.parse(startDate), LocalDate.parse(endDate)));
    }

    public List<WorkoutSession> viewWorkoutAvailability(String workoutType, String date) {
        LocalDate targetDate = LocalDate.parse(date);
        List<WorkoutSession> availableSessions = new ArrayList<>();

        for (WorkoutSession session : sessions) {
            if (session.getWorkoutType().equals(workoutType) && targetDate.isAfter(session.getStartDate()) && targetDate.isBefore(session.getEndDate()) && session.getAvailableSeats() > 0) {
                availableSessions.add(session);
            }
        }
        return availableSessions;
    }
}

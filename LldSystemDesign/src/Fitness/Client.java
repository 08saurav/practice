package Fitness;

import Fitness.models.User;
import Fitness.models.WorkoutSession;
import Fitness.services.BookingService;
import Fitness.services.FitnessService;
import Fitness.services.UserService;
import Fitness.services.WorkoutService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        FitnessService fitnessService = new FitnessService();

        // Admin adding workouts
        fitnessService.addWorkout("Koramangala", "Weights", 6, 7, 100, "01-08-24", "30-08-24");
        fitnessService.addWorkout("Koramangala", "Cardio", 7, 8, 150, "01-08-24", "30-08-24");
        fitnessService.addWorkout("Koramangala", "Yoga", 8, 9, 200, "01-08-24", "30-08-24");
        fitnessService.addWorkout("Koramangala", "Swimming", 8, 9, 200, "01-08-24", "30-08-24");

        fitnessService.addWorkout("Bellandur", "Weights", 18, 19, 100, "01-08-24", "30-08-24");
        fitnessService.addWorkout("Bellandur", "Cardio", 18, 19, 20, "01-08-24", "30-08-24");

        // User Registration
        fitnessService.registerUser("Sourabh", "sourabh@email.com", "Hsr");

        // View workout slot availability
        fitnessService.viewWorkoutSlotAvailability("Weights", "20-08-24");

        // Booking a workout session
        fitnessService.bookSession("Sourabh", "Koramangala", "Weights", 6, 7, "20-08-24");

        // View updated workout slot availability
        fitnessService.viewWorkoutSlotAvailability("Weights", "20-08-24");

        // View user schedule
        fitnessService.viewSchedule("Sourabh", "20-08-24", "Koramangala", "Weights");
    }
}

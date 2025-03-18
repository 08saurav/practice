package Fitness.services;

import Fitness.models.Booking;
import Fitness.models.User;
import Fitness.models.WorkoutSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    List<Booking> bookings = new ArrayList<>();

    public boolean bookSession(User user, WorkoutSession session, String date) {
        LocalDate bookingDate = LocalDate.parse(date);
        if (session.getAvailableSeats() > 0) {
            session.setAvailableSeats(session.getAvailableSeats() - 1);
            bookings.add(new Booking(user, session, bookingDate));
            return true;
        }
        return false;
    }
}

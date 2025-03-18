package Fitness.models;

import java.time.LocalDate;

public class Booking {
    User user;
    WorkoutSession session;
    LocalDate date;

    public Booking(User user, WorkoutSession session, LocalDate date) {
        this.user = user;
        this.session = session;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkoutSession getSession() {
        return session;
    }

    public void setSession(WorkoutSession session) {
        this.session = session;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

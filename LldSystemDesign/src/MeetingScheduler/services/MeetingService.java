package MeetingScheduler.services;

import MeetingScheduler.models.Meeting;
import MeetingScheduler.repositories.MeetingRepository;

import java.util.Date;
import java.util.List;

public class MeetingService {
    private MeetingRepository repository;

    public MeetingService(MeetingRepository repository) {
        this.repository = repository;
    }

    public void scheduleMeeting(int id, String title, Date startTime, Date endTime, List<Integer> participants) {
        repository.addMeeting(new Meeting(id, title, startTime, endTime, participants));
    }
    public void cancelMeeting(int meetingId) {
        repository.removeMeeting(meetingId);
    }

    public List<Meeting> getUserMeetings(int userId) {
        return repository.getUserMeetings(userId);
    }

    public List<Meeting> findAvailableSlots(int userId) {
        return getUserMeetings(userId); // Placeholder for logic
    }
}

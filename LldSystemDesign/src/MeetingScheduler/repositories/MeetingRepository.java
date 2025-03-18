package MeetingScheduler.repositories;

import MeetingScheduler.models.Meeting;

import java.util.*;

public class MeetingRepository {
    private Map<Integer, Meeting> meetings;
    private Map<Integer, List<Meeting>> userMeetings;
    public MeetingRepository() {
        meetings = new HashMap<>();
        userMeetings = new HashMap<>();
    }
    public void addMeeting(Meeting meeting) {
        meetings.put(meeting.getId(), meeting);
        for(int participantId : meeting.getParticipants()) {
            userMeetings.computeIfAbsent(participantId, k -> new ArrayList<>()).add(meeting);
        }
    }
    public void removeMeeting(int meetingId) {
        Meeting meeting = meetings.get(meetingId);
        meetings.remove(meeting.getId());
        for (int participant : meeting.getParticipants()) {
            userMeetings.getOrDefault(participant, new ArrayList<>()).remove(meeting);
        }
    }
    public List<Meeting> getMeetings() {
        return new ArrayList<>(meetings.values());
    }
    public List<Meeting> getUserMeetings(int userId) {
        return userMeetings.getOrDefault(userId, Collections.emptyList());
    }
}

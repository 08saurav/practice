package MeetingScheduler;

import MeetingScheduler.repositories.MeetingRepository;
import MeetingScheduler.services.MeetingService;

import java.util.Arrays;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        MeetingRepository repository = new MeetingRepository();
        MeetingService service = new MeetingService(repository);

        // Adding meetings
        service.scheduleMeeting(1, "Team Sync", new Date(), new Date(), Arrays.asList(1, 2));
        service.scheduleMeeting(2, "Project Review", new Date(), new Date(), Arrays.asList(2, 3));

        // List meetings for user1
        System.out.println("Meetings for user2: " + service.getUserMeetings(2).size());

        // Cancel a meeting
        service.cancelMeeting(2);

        // List meetings for user1 after cancellation
        System.out.println("Meetings for user2 after cancellation: " + service.getUserMeetings(2).size());
    }
}

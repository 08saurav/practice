package MeetingScheduler.models;

import java.util.Date;
import java.util.List;

public class Meeting {
    private int id;
    private String title;
    private Date startTime;
    private Date endTime;
    private List<Integer> participants;

    public Meeting(int id, String title, Date startTime, Date endTime, List<Integer> participants) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Integer> participants) {
        this.participants = participants;
    }
}

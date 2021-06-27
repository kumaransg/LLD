package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class Room {
    String name;
    String id;
    ArrayList<Meeting> calendar;

    public Room(String name) {
        this.id = UUID.randomUUID().toString();
        this.calendar = new ArrayList<>();
        this.name = name;
    }

    public boolean bookRoom(int start, int end) {
        // loop over the calender and check if the lost is already booked;
        // else creating a meeting and add
        // 11.00 to 12.00
        for (Meeting meeting : calendar) {
            if (start >= meeting.startTime && end <= meeting.endTime || (start <= meeting.startTime
                && end > meeting.startTime && end <= meeting.endTime) || start >= meeting.startTime
                && start < meeting.endTime && end > meeting.endTime) {
                return false;
            }
        }
        // create the meeting
        Meeting meeting = new Meeting(start, end, this.id);
        calendar.add(meeting);
        return true;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

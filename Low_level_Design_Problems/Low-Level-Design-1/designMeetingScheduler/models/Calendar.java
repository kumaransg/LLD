/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designMeetingScheduler.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: Calendar.java, v 0.1 2021-03-18 10:38 AM paras.chawla Exp $$
 */

// Every Calendar belongs to particular Meeting room
public class Calendar {

    // Every Calendar belongs to particular Meeting Room
    MeetingRoom room;

    // Every Calendar is having List of Meetings
    List<Meeting> meetingList;

    public Calendar() {
        this.meetingList = new ArrayList<>();
    }

    public boolean checkAvailablity(Date startTime, Date endTime) {

        for (Meeting meeting : meetingList) {
            // Meeting (9 AM to 10:30 AM)
            // Meeting can't be schedule  10:00 - 11:00 AM                            8:00 to 9:15
            if (meeting.endTime.compareTo(startTime) > 0 && meeting.startTime.compareTo(endTime) < 0) {
                return false;
            }
        }
        return true;
    }

    public Meeting scheduleNewMeeting(Date startTime, Date endTime) {
        Meeting meeting = new Meeting(room, startTime, endTime);
        meetingList.add(meeting);
        return meeting;
    }
}
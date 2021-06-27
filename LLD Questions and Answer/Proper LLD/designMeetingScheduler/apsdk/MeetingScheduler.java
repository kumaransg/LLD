/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designMeetingScheduler.apsdk;

import designMeetingScheduler.models.Attendee;
import designMeetingScheduler.models.Meeting;
import designMeetingScheduler.models.MeetingRoom;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: MeetingScheduler.java, v 0.1 2021-03-18 12:55 PM paras.chawla Exp $$
 */
public class MeetingScheduler {

    List<MeetingRoom> meetingRoomList;

    // History of all meetings are required
    Deque historyQueue;

    // max History should be 20
    private static final int MAX_HISTORICAL_MEETING_STORAGE = 20;

    public MeetingScheduler(List<MeetingRoom> meetingRoomList) {
        this.meetingRoomList = meetingRoomList;
        this.historyQueue = new ArrayDeque(20);
    }

    public Meeting bookRoom(Date startDate, Date endDate) {

        // Traverse all meeting Rooms
        for (MeetingRoom meetingRoom : meetingRoomList) {

            if (meetingRoom.isAvailable(startDate, endDate)) {
                Meeting newMeeting = meetingRoom.scheduleMeeting(startDate, endDate);
                saveToHistory(newMeeting);
                return newMeeting;
            }
        }
        return null;
    }

    public Meeting bookParticularMeetingRoom(MeetingRoom meetingRoom, Date startDate, Date endDate) {

        // Traverse all meeting Rooms
        if (meetingRoom.isAvailable(startDate, endDate)) {
            Meeting newMeeting = meetingRoom.scheduleMeeting(startDate, endDate);
            saveToHistory(newMeeting);
            return newMeeting;
        }

        return null;
    }

    private void saveToHistory(Meeting newMeeting) {

        if (historyQueue.size() == MAX_HISTORICAL_MEETING_STORAGE) {
            historyQueue.removeFirst();
        }
        historyQueue.addLast(newMeeting);
    }

    public void invite(Meeting meeting, List<Attendee> attendees) {
        meeting.invite(attendees);
    }

}
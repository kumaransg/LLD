/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designMeetingScheduler;

import designMeetingScheduler.apsdk.MeetingScheduler;
import designMeetingScheduler.models.Calendar;
import designMeetingScheduler.models.MeetingRoom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: Main.java, v 0.1 2021-03-18 1:07 PM paras.chawla Exp $$
 */
public class Main {

    public static void main(String[] args) {

        MeetingRoom room1 = new MeetingRoom("Mercury", new Calendar());
        MeetingRoom room2 = new MeetingRoom("Venus", new Calendar());
        MeetingRoom room3 = new MeetingRoom("Earth", new Calendar());

        List<MeetingRoom> meetingRoomList = new ArrayList<>();
        meetingRoomList.add(room1);
        meetingRoomList.add(room2);
        meetingRoomList.add(room3);

        MeetingScheduler scheduler = new MeetingScheduler(meetingRoomList);

        Date starteDate = new Date(2021, 3, 18, 10, 0, 0);
        Date endDate = new Date(2021, 3, 18, 11, 0, 0);
        scheduler.bookParticularMeetingRoom(room1, starteDate, endDate);

    }
}
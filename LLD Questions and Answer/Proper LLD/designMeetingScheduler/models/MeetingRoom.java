/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designMeetingScheduler.models;

import lombok.AllArgsConstructor;

import java.util.Date;

/**
 * @author paras.chawla
 * @version $Id: MeetingRoom.java, v 0.1 2021-03-18 10:37 AM paras.chawla Exp $$
 */
@AllArgsConstructor
public class MeetingRoom {

    private String roomName;

    // Every Meeting Room has its own Calendar
    Calendar calendar;

    public boolean isAvailable(Date startTime, Date endTime){
        return calendar.checkAvailablity(startTime,endTime);
    }

    public Meeting scheduleMeeting(Date startTime, Date endTime){
        return calendar.scheduleNewMeeting(startTime,endTime);
    }

}
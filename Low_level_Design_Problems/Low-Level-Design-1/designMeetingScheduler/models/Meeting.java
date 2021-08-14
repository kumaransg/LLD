/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designMeetingScheduler.models;

import designMeetingScheduler.service.EmailService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author paras.chawla
 * @version $Id: Meeting.java, v 0.1 2021-03-18 10:39 AM paras.chawla Exp $$
 */
public class Meeting {

    int  id;
    Date startTime;
    Date endTime;

    // This particular meeting is for which Room
    MeetingRoom meetingRoom;

    List<Attendee> attendeeList;

    // Person who booked the meeting
    Attendee bookedBy;

    EmailService emailService;

    final String EMAIL_NOTIFICATION_TEMPLATE_NAME = "Hi";

    public Meeting(MeetingRoom meetingRoom, Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingRoom = meetingRoom;
        id = UUID.randomUUID().clockSequence();
    }

    /**
     * Use AWS SES for transactional emails.
     */
    public void invite(List<Attendee> attendees) {
        // this is a bit of Groovy, just for fun.
        emailService.sendBulkEmail(
                EMAIL_NOTIFICATION_TEMPLATE_NAME,
                new ArrayList<>(),
                new HashMap<>()
        );
    }
}
package com.sss.mcoding.models;

import java.util.Date;

//Immutable once created. No Setter
public class TimeSlot implements Comparable<TimeSlot> {

    private Date startTime;
    private Date endTime;

    public TimeSlot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(TimeSlot o) {
        return this.startTime.compareTo(o.startTime);
    }
}

package com.sss.mcoding.models;

import java.util.List;

public class Event implements Comparable<Event>{

    private String name;
//    private List<Participant> participants;
    private List<User> userParticipants;
    private TimeSlot timeSlot;

    public Event(String name, List<User> userParticipants, TimeSlot timeSlot) {
        this.name = name;
        this.userParticipants = userParticipants;
        this.timeSlot = timeSlot;
    }

    public String getName() {
        return name;
    }

    public List<User> getUserParticipants() {
        return userParticipants;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }


    @Override
    public int compareTo(Event o) {
        return this.timeSlot.compareTo(o.timeSlot);
    }
}

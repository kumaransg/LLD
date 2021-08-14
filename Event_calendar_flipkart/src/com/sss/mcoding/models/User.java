package com.sss.mcoding.models;

import java.util.Optional;
import java.util.TreeSet;

public class User extends Participant{

    private TimeSlot workingHours;
    private Optional<Team> team;
    private TreeSet<Event> events;

    public User(String name, TimeSlot workingHours) {
        super(name);
        this.workingHours = workingHours;
        this.team = Optional.empty();
        this.events = new TreeSet<>();
    }

    public TimeSlot getWorkingHours() {
        return workingHours;
    }

    public Optional<Team> getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = Optional.of (team);
    }

    public TreeSet<Event> getEvents() {
        return events;
    }
}

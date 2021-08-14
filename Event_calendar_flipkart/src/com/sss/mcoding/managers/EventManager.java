package com.sss.mcoding.managers;

import com.sss.mcoding.app.EventCalendar;
import com.sss.mcoding.models.Event;
import com.sss.mcoding.models.Team;
import com.sss.mcoding.models.TimeSlot;
import com.sss.mcoding.models.User;

import java.sql.Time;
import java.util.*;

public class EventManager {

    private UserManager userManager;
    private TeamManager teamManager;
    private Map<String, Event> eventMap;

    public EventManager(UserManager userManager, TeamManager teamManager) {
        this.userManager = userManager;
        this.teamManager = teamManager;
        eventMap = new HashMap<>();
    }

    public void createEvent(String eventName, List<String> users, List<String> teams, int representation, Date startTime, Date endTime) {
        List<User> eventUsers = new ArrayList<>();

        for (String userName : users) {
            User user = userManager.getUser(userName);
            if (!willUserBeAvailable(user, startTime, endTime)) {
                throw new RuntimeException("Event " + eventName + " not possible");
            } else {
                eventUsers.add(user);
            }
        }

        for (String teamName : teams) {
            Team team = teamManager.getTeam(teamName);
            int repsFound = 0;
            for (User user : team.getTeamMembers()) {
                if (willUserBeAvailable(user, startTime, endTime)) {
                    repsFound++;
                    eventUsers.add(user);
                }
                if (repsFound == representation) {
                    break;
                }
            }
            if (repsFound < representation) {
                throw new RuntimeException("Event " + eventName + " not possible");
            }
        }

        Event event = new Event(eventName, eventUsers, new TimeSlot(startTime, endTime));
        eventMap.put(eventName, event);
        for (User user : eventUsers) {
            userManager.addEvent(user, event);
        }
    }

    private boolean willUserBeAvailable(User user, Date startTime, Date endTime) {

        TreeSet<Event> events = user.getEvents();
        // 3-5,  7-9
        // 4-6
        // 6-6
        // 3-5  - 5.compare(4) > 0
        Event event = events.lower(new Event("dummy", null,  new TimeSlot(endTime, endTime)));
        if (event != null && event.getTimeSlot().getEndTime().compareTo(startTime) > 0) {
            return false;
        } else {
            return true;
        }
    }
}



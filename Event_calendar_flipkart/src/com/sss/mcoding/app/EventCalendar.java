package com.sss.mcoding.app;

import com.sss.mcoding.managers.EventManager;
import com.sss.mcoding.managers.TeamManager;
import com.sss.mcoding.managers.UserManager;
import com.sss.mcoding.models.Event;
import com.sss.mcoding.models.TimeSlot;
import com.sss.mcoding.models.User;

import java.util.Date;
import java.util.List;

public class EventCalendar {

    private UserManager userManager;
    private TeamManager teamManager;
    private EventManager eventManager;

    public EventCalendar() {
        userManager = new UserManager();
        teamManager = new TeamManager(userManager);
        eventManager = new EventManager(userManager, teamManager);
    }

    public void createUser(String name, Date startTime, Date endTime) {
        TimeSlot workingHours = new TimeSlot(startTime, endTime);
        userManager.createUser(name, workingHours);
    }

    public void createTeam(String name, List<String> userNames) {
        teamManager.createTeam(name, userNames);
    }

    public void createEvent(String eventName, List<String> userNames, List<String> teamNames, int rep, Date startTime, Date endTime) {
        eventManager.createEvent(eventName, userNames, teamNames, rep, startTime, endTime);
    }

    public void printUser(String userId) {
        User user = userManager.getUser(userId);

        for (Event event : user.getEvents()) {
            System.out.println(userId + " - "+ event.getName() + " - " + event.getTimeSlot().getStartTime() + " - " + event.getTimeSlot().getEndTime());
        }

    }


}

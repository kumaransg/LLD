package com.sss.mcoding.managers;

import com.sss.mcoding.dao.UserDao;
import com.sss.mcoding.models.Event;
import com.sss.mcoding.models.Team;
import com.sss.mcoding.models.TimeSlot;
import com.sss.mcoding.models.User;

public class UserManager {

    private UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }

    public User createUser(String username, TimeSlot timeSlot) {
        User newUser = new User(username, timeSlot);
        userDao.addUser(newUser);
        return newUser;
    }

    public User getUser(String userName) {
        return userDao.getUser(userName);
    }

    public boolean checkIfUserPartOfAnyTeam(String userName) {
        User user = userDao.getUser(userName);
        return user.getTeam().isPresent();
    }

    public void setTeam(User user, Team team) {
        userDao.setTeam(user, team);
    }

    public void addEvent(User user, Event event) {
        userDao.addEvent(user, event);
    }
}

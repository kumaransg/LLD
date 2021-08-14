package com.sss.mcoding.models;

import java.util.ArrayList;
import java.util.List;

public class Team extends Participant{

    private List<User> teamMembers;

    public Team(String name) {
        super(name);
        this.teamMembers = new ArrayList<>();
    }

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(User user) {
        this.teamMembers.add(user);
    }
}

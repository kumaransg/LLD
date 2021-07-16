package com.system.design.oops.stackoverflow;

import java.util.List;

public class Member {
    private Account account;
    private List<Badge> badges;

    public int getReputation(){ return 0;}
    public String getEmail(){ return null;}
    public boolean createQuestion(Question question){ return true;}
    public boolean createTag(Tag tag){ return true;}
}

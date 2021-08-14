package com.system.design.oops.stackoverflow;

import java.util.Date;

public class Comment {
    private String text;
    private Date creationTime;
    private int flagCount;
    private int voteCount;

    private Member askingMember;

    public boolean incrementVoteCount(){ return true;}
}
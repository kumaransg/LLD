package com.system.design.oops.stackoverflow;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Question implements Search {
    private String title;
    private String description;
    private int viewCount;
    private int voteCount;
    private Date creationTime;
    private Date updateTime;
    private QuestionStatus status;
    private QuestionClosingRemark closingRemark;

    private Member askingMember;
    private Bounty bounty;
    private List<Photo> photos;
    private List<Comment> comments;
    private List<Answer> answers;

    public boolean close(){ return true;}
    public boolean undelete(){ return true;}
    public boolean addComment(Comment comment){ return true;}
    public boolean addBounty(Bounty bounty){ return true;}

    public static List<Question> search(String query) {
        // return all questions containing the string query in their title or description.
        return Collections.emptyList();
    }
}

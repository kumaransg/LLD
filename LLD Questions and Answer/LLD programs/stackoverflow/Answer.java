package stackoverflow;

import java.util.List;

public class Answer extends Entity{
    boolean isAccepted;
    List<Comment> comments;
    public boolean addAnswer(Question question) {return false;}
}

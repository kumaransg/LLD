package stackoverflow;

import java.util.List;

public class Question extends Entity{
    String description;
    String title;
    List<Comment> comments;
    List<Tag> tags;
    List<Answer> answers;
    
    public void addTag(Tag tag) {}
}

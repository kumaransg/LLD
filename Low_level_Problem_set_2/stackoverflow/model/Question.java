package stackoverflow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Question extends Entity {
    private final List<Answer> answers;
    private final List<Comment> comments;
    private Integer bounty;
    private final List<Tag> tags;
    private Boolean isOpen;

    public Question(String content, Member owner) {
        super(content, owner);
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.bounty = 0;
        this.tags = new ArrayList<>();
        this.isOpen = true;
    }

    public Integer getBounty() {
        return bounty;
    }

    public void setBounty(Integer bounty) {
        this.bounty = bounty;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public String toString() {
        return "Question{" +
                "Content= " + super.getContent() +
                ", answers=" + answers +
                ", comments=" + comments +
                ", bounty=" + bounty +
                ", tags=" + tags +
                ", isOpen=" + isOpen +
                ", owner=" + super.getOwner() +
                '}';
    }
}

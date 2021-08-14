package stackoverflow.model;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Comment extends Entity {
    public Comment(String content, Member owner) {
        super(content, owner);
    }

    @Override
    public String toString() {
        return "Comment{ " +
                " Content= " + super.getContent() +
                " Owner= " + super.getOwner() +
                "}";
    }
}

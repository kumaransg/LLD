package model;

import java.util.UUID;

public class Comment {
    String commentId;
    String Comment;

    public Comment(String comment) {
        this.commentId = UUID.randomUUID().toString();
        this.Comment = comment;
    }

    // only read a comment;
    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return Comment;
    }
}

package lowleveldesign.facebook.api.core.entities.userdefinedtypes;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.comment.CommentLikedBy;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.comment.CommentPostedBy;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.comment.CommentPostedOn;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.Set;
import java.util.UUID;

@UserDefinedType("comment_type")
public class Comment {

    @CassandraType(type = CassandraType.Name.UUID)
    @Column("comment_id")
    private UUID commentId;

    @CassandraType(userTypeName = "comment_posted_by_type", type = CassandraType.Name.UDT)
    @Column("comment_posted_by")
    private CommentPostedBy postedBy;

    @CassandraType(userTypeName = "comment_posted_on_type", type = CassandraType.Name.UDT)
    @Column("comment_posted_on")
    private CommentPostedOn postedOn;

    @Column("comment")
    private String comment;

    @CassandraType(userTypeName = "comment_liked_by_type", type = CassandraType.Name.UDT)
    @Column("comment_liked_by")
    private Set<CommentLikedBy> commentLikedBy;

}

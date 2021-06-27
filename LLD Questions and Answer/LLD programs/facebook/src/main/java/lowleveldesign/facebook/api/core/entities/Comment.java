package lowleveldesign.facebook.api.core.entities;

import lombok.Data;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.comment.CommentLikedBy;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.comment.CommentPostedBy;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.comment.CommentPostedOn;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Data
@Table("comments")
public class Comment {

    @PrimaryKeyColumn(name = "comment_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
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

    @CassandraType(userTypeName = "comment_type", type = CassandraType.Name.UDT)
    @Column("replies")
    private Set<lowleveldesign.facebook.api.core.entities.userdefinedtypes.Comment> replies;

}

package lowleveldesign.facebook.api.core.entities;

import lombok.Data;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.post.PostLikedBy;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.post.PostSharedBy;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.net.InetAddress;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Table("posts")
public class Post {

    @PrimaryKeyColumn(name = "posted_by_entity_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID postedByEntityId;

    @PrimaryKeyColumn(name = "post_timestamp", type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.DATE)
    @Column("posted_at")
    private Date postedAt;

    @PrimaryKeyColumn(name = "post_id", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID postId;

    @PrimaryKeyColumn(name = "posted_on_entity_id", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID postedOnEntityId;

    @CassandraType(userTypeName = "post_liked_by_type", type = CassandraType.Name.UDT)
    @Column("post_liked_by")
    private Set<PostLikedBy> postLikedBy;

    @CassandraType(userTypeName = "comment_type", type = CassandraType.Name.UDT)
    @Column("comments")
    private Set<lowleveldesign.facebook.api.core.entities.userdefinedtypes.Comment> comments;

    @CassandraType(userTypeName = "post_shared_by_type", type = CassandraType.Name.UDT)
    @Column("post_shared_by")
    private Set<PostSharedBy> postSharedBy;

    @Column("post_text")
    private String text;

    @CassandraType(type = CassandraType.Name.INET)
    @Column("image_url")
    private InetAddress imageUrl;

    @CassandraType(type = CassandraType.Name.INET)
    @Column("video_url")
    private InetAddress videoUrl;

    @Column("is_live_stream")
    private boolean isLiveStream;

    @CassandraType(type = CassandraType.Name.INET)
    @Column("stream_url")
    private InetAddress streamUrl;

}

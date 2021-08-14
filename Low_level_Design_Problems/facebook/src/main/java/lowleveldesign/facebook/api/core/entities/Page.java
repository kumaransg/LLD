package lowleveldesign.facebook.api.core.entities;

import lombok.Data;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Address;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Location;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.page.Follower;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.page.PageAdmin;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Data
@Table("pages")
public class Page {

    @PrimaryKeyColumn(name = "entity_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID entityId;

    @PrimaryKeyColumn(name = "entity_name", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @Column("entity_name")
    private String entityName; // equivalent of username

    @Column("page_name")
    private String name;

    @Column("page_avatar_url")
    private String avatarUrl;

    @Column("page_background_url")
    private String backgroundUrl;

    @Column("page_thumbnail_url")
    private String thumbnailUrl;

    @Column("page_summary")
    private String summary;

    @CassandraType( userTypeName = "page_admin_type", type = CassandraType.Name.UDT)
    @Column("page_admins")
    private Set<PageAdmin> admins;

    @CassandraType(userTypeName = "follower_type", type = CassandraType.Name.UDT)
    @Column("followers")
    private Set<Follower> followers;

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("page_location")
    private Location location;

    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("page_address")
    private Address address;

}

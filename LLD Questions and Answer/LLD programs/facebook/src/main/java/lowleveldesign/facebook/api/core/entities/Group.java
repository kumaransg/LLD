package lowleveldesign.facebook.api.core.entities;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Address;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.group.GroupAdmin;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.group.GroupMember;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.location.Location;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Table("groups")
public class Group {

    @PrimaryKeyColumn(name = "entity_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID entityId;

    @PrimaryKeyColumn(name = "entity_name", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @Column("entity_name")
    private String entityName;

    @Column("group_name")
    private String name;

    @Column("group_avatar_url")
    private String avatarUrl;

    @Column("group_background_url")
    private String backgroundUrl;

    @Column("group_thumbnail_url")
    private String thumbnailUrl;

    @Column("group_summary")
    private String summary;

    @CassandraType(userTypeName = "group_admin_type", type = CassandraType.Name.UDT)
    @Column("group_admins")
    private Set<GroupAdmin> admins;

    @CassandraType(userTypeName = "group_member_type", type = CassandraType.Name.UDT)
    @Column("group_members")
    private Set<GroupMember> members;

    @CassandraType(userTypeName = "location_type", type = CassandraType.Name.UDT)
    @Column("group_location")
    private Location location;

    @CassandraType(userTypeName = "address_type", type = CassandraType.Name.UDT)
    @Column("group_address")
    private Address address;

}

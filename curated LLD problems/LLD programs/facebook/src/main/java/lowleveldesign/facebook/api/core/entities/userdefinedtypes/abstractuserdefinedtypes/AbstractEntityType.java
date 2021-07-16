package lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;

import java.util.UUID;

public abstract class AbstractEntityType {

    @CassandraType(type = CassandraType.Name.UUID)
    @Column("entity_id")
    private UUID entityId;

    @CassandraType(type = CassandraType.Name.TEXT)
    @Column("entity_name")
    private String entityName;

    private String name;

    @Column("thumbnail_url")
    private String thumbnailUrl;

}

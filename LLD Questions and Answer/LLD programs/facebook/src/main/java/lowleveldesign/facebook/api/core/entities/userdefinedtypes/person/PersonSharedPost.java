package lowleveldesign.facebook.api.core.entities.userdefinedtypes.person;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.AbstractEntityType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.UUID;

@UserDefinedType("person_shared_post_type")
public class PersonSharedPost extends AbstractEntityType {

    @CassandraType(type = CassandraType.Name.UUID)
    @Column("posted_by_entity_id")
    private UUID postedByEntityId;

}

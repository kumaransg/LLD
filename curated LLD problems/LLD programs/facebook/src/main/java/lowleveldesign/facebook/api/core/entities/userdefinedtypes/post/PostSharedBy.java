package lowleveldesign.facebook.api.core.entities.userdefinedtypes.post;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.AbstractEntityType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("post_shared_by_type")
public class PostSharedBy extends AbstractEntityType {
}

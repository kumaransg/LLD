package lowleveldesign.facebook.api.core.entities.userdefinedtypes.location;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.AbstractLocationEntityType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("locality_type")
public class Locality extends AbstractLocationEntityType {
}

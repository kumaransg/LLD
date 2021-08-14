package lowleveldesign.facebook.api.core.entities.userdefinedtypes.location;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.AbstractLocationEntityType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("continent_type")
public class Continent extends AbstractLocationEntityType {
}

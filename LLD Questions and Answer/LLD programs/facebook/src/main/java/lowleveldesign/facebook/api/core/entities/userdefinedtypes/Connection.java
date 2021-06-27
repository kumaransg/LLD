package lowleveldesign.facebook.api.core.entities.userdefinedtypes;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.AbstractEntityType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("connection_type")
public class Connection extends AbstractEntityType {

}

package lowleveldesign.facebook.api.core.entities.userdefinedtypes.person;


import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.AbstractEntityType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("person_group_type")
public class PersonGroup extends AbstractEntityType {

}

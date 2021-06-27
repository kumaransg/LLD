package lowleveldesign.facebook.api.core.entities.userdefinedtypes.group;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.Admin;
import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.Member;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("group_member_type")
public class GroupMember extends Member {

}


package lowleveldesign.facebook.api.core.entities.userdefinedtypes.page;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.Member;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("follower_type")
public class Follower extends Member {

}



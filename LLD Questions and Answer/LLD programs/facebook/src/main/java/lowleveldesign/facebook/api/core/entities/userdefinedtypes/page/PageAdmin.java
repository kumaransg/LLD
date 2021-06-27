package lowleveldesign.facebook.api.core.entities.userdefinedtypes.page;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.Admin;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.UUID;

@UserDefinedType("page_admin_type")
public class PageAdmin extends Admin {

}

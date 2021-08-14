package lowleveldesign.facebook.api.core.entities.userdefinedtypes.comment;

import lowleveldesign.facebook.api.core.entities.userdefinedtypes.abstractuserdefinedtypes.AbstractEntityType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("comment_posted_by_type")
public class CommentPostedBy extends AbstractEntityType {

}

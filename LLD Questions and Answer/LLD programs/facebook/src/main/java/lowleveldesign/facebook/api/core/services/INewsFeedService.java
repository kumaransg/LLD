package lowleveldesign.facebook.api.core.services;

import lowleveldesign.facebook.api.core.entities.Post;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface INewsFeedService {

    Set<Post> getUserFeed(UUID userId, Date sinceTimestamp, Optional<Integer> count, Optional<Date> maxTimestamp, boolean excludeReplies);

}

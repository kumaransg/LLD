package lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.implementations;

import lowleveldesign.facebook.api.core.entities.Person;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.ISocialPointsStrategy;

public class MemberGroupsStrategy implements ISocialPointsStrategy {
    @Override
    public Double apply(Person person) {
        long totalGroupCount = /* getTotalGroupCount() from DB */ 10000l;
        return (double) totalGroupCount / (totalGroupCount - person.getMemberGroups().size());
    }
}

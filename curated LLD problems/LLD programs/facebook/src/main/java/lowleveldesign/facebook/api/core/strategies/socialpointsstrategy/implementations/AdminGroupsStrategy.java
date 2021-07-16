package lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.implementations;

import lowleveldesign.facebook.api.core.entities.Person;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.ISocialPointsStrategy;

public class AdminGroupsStrategy implements ISocialPointsStrategy {
    @Override
    public Double apply(Person person) {
        long totalPersonCount = /* getTotalPersonCount() from DB */ 10000l;
        long totalUniqueMembersFromAdminGroups = /* getTotalUniqueMembersCountFromAdminGroups() from DB */ 10000l;
        return (double) totalPersonCount / (totalPersonCount - totalUniqueMembersFromAdminGroups);
    }
}

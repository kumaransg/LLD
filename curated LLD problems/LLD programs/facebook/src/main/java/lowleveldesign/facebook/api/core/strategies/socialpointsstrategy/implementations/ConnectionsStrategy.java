package lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.implementations;

import lowleveldesign.facebook.api.core.entities.Person;
import lowleveldesign.facebook.api.core.strategies.socialpointsstrategy.ISocialPointsStrategy;

public class ConnectionsStrategy implements ISocialPointsStrategy {
    @Override
    public Double apply(Person person) {
        long totalPersonCount = /* getTotalPersonCount() from DB */ 100000;
        return (double) totalPersonCount / (totalPersonCount - person.getConnections().size());
    }
}

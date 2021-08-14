package RideAlgorithm;

import model.Ride;

import java.util.HashMap;
import java.util.Map;

public class RiderFactory {
    private Map<String, IRideSelectionStrategy> commandMap;

    public RiderFactory(){
        commandMap= new HashMap<>();
        commandMap.put("Most Vacant",new MostVacantStrategy());
        commandMap.put("Preferred Vehicle",new PreferredVehicleStrategy());
    }

    public Ride getRideSelectionStrategy(String src, String dest, int seats, String args){
        String []vals= args.split("=");

        return commandMap.get(vals[0]).getRide(src, dest, seats, args);
    }
}

package RideAlgorithm;

import model.Ride;

public interface IRideSelectionStrategy {
    Ride getRide(String src,String dest,int seats,String params);
}

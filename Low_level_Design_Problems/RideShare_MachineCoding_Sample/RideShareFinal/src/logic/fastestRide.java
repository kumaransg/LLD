package logic;

import java.util.Comparator;

import model.ride;

public class fastestRide implements Comparator<ride>{
	public int compare(ride a,ride b){
        return a.getRide_duration()-b.getRide_duration();//ascending
    }
	
}

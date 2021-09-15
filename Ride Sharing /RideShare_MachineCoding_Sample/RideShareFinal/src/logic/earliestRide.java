package logic;

import model.ride;
import java.util.Comparator;


public class earliestRide implements Comparator <ride> {
	public int compare(ride a,ride b){
		return a.getStartTime().compareTo(b.getStartTime());
	}

}

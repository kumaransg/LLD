package business.logic.implementation;

import java.util.ArrayList;
import java.util.HashMap;

import business.logic.implementation.BusinessLogicImplementation;
public class EligibleDrivers {


	public void calculateEligibleDriverAndRating(String Customer) throws NullPointerException {
		BusinessLogicImplementation Bobj= new BusinessLogicImplementation(); 
		HashMap<String,ArrayList<Integer>>map=Bobj.eligibleDrivers(Customer);
		
		for (HashMap.Entry<String,ArrayList<Integer>> entry : map.entrySet()) 
		{
			int s=0;
			for(int i=0;i<entry.getValue().size();i++) {s+=entry.getValue().get(i);}
			//if((float)s/entry.getValue().size()>BusinessLogicImplementation.R)
			System.out.println("Driver: "+entry.getKey()+" Avg Rating: "+(float)s/entry.getValue().size());
		} 
		
	}
}

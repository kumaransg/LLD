package application;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

import business.logic.implementation.*;

public class mainClass {

	public static void main(String []args) throws IOException 
	{
		/*System.out.println("Please enter customer's name:");
		 BufferedReader reader =  
                 new BufferedReader(new InputStreamReader(System.in)); 
		String name = reader.readLine(); 
		*/
		
		EligibleDrivers edobj= new EligibleDrivers();
		edobj.calculateEligibleDriverAndRating("c3");
		
		System.out.println("Customer Rating:");
		
		BusinessLogicImplementation blobj= new BusinessLogicImplementation();
		blobj.CalculateCustomerRating("c3");
		
		
		 
		
	}
}

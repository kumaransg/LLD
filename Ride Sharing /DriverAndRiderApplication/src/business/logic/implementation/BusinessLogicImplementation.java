package business.logic.implementation;

import java.util.ArrayList;
import java.util.HashMap;

import business.logic.BusinessLogic;
import data.DummyData;


public class BusinessLogicImplementation extends BusinessLogic {
	static float R;
	HashMap<String, Integer> onlinedrivershash=new HashMap<>();
	
	
	public HashMap<String,ArrayList<Integer>> eligibleDrivers(String CustomerName) throws NullPointerException
	{
		HashMap<String,Boolean>SearchedDrivers=new HashMap<>();
		HashMap<String,ArrayList<Integer>>eligibleDrivers=new HashMap<>();
		
		for(int i=0;i<DummyData.dataArray.length;i++) 
		{
			String DriverName=DummyData.dataArray[i][0];
			if(SearchedDrivers.get(DriverName)==null) 
			{
				ArrayList<Integer>tempList=new ArrayList<>();
				SearchedDrivers.put(DriverName,true);
				eligibleDrivers.put(DriverName,tempList);
			}
			
			if(SearchedDrivers.get(DriverName)==true) 
			{
				//remove a driver which has 1 rating 
				if(onlinedrivershash.get(DummyData.dataArray[i][0])!=null&&onlinedrivershash.get(DummyData.dataArray[i][0])==0)
				{
					eligibleDrivers.remove(DriverName);
					continue;
				}
				if(DummyData.dataArray[i][1]=="1"&&DummyData.dataArray[i][2]==CustomerName) 
				{
					eligibleDrivers.remove(DriverName);
					continue;
				}
				
				eligibleDrivers.get(DriverName).add(Integer.parseInt(DummyData.dataArray[i][1]));
			}
			
		}
	return eligibleDrivers;
	} 
	
	//search for rating 
	public void CalculateCustomerRating(String CustomerName) throws NullPointerException 
	{
		int Rating=0;
		HashMap<String,Boolean>SearchedCustomer=new HashMap<>();
		//HashMap<String,ArrayList<Integer>>eligibleDrivers=new HashMap<>();
		int count=0;
		
		for(int i=0;i<DummyData.dataArray.length;i++) 
		{
	
			if(DummyData.dataArray[i][2]==CustomerName) 
			{
				count++;
				Rating+=Integer.parseInt(DummyData.dataArray[i][3]);
			}
			
		}
		//System.out.println("data"+count+" "+Rating);
		if(count!=0) 
		{
			R=(float)Rating/count;
			System.out.println( (float)Rating/count);
		}
		else 
			System.out.println("No Customer Rating found");
	}
}

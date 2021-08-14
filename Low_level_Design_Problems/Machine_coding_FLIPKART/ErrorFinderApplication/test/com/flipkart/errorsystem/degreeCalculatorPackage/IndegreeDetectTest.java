//package com.flipkart.errorsystem.degreeCalculatorPackage;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.flipkart.errorsystem.PairPackage.PairTest;
//
//public class IndegreeDetectTest {
//
//	ArrayList<Integer>Indegree= new ArrayList<Integer>(256);
//	
//	public IndegreeDetectTest(){
//		for(int i=0;i<256;i++) 
//		{
//			Indegree.add(i, 0);
//		}
//	}
//	public ArrayList<Integer> IndegCal(ArrayList<PairTest>List)
//	{
//		
//	   for(int i=0;i<List.size();i++) {
//		   Indegree.set(List.get(i).second-'A', Indegree.get(List.get(i).second-'A')+1);
//
//		}
//	  // printIndeg();
//		return Indegree;
//		
//	}
//	void printIndeg() 
//	{
//		for(int i=0;i<256;i++) 
//		{
//			System.out.println("\nIn: "+i+": "+Indegree.get(i));
//		}
//	}
//}

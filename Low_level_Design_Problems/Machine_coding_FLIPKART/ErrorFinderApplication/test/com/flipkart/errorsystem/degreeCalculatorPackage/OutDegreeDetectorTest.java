//package com.flipkart.errorsystem.degreeCalculatorPackage;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.flipkart.errorsystem.PairPackage.PairTest;
//
//public class OutDegreeDetectorTest {
//
//
//		ArrayList<Integer>Outdegree= new ArrayList<Integer>(256);
//		
//		public OutDegreeDetectorTest(){
//			for(int i=0;i<256;i++) 
//			{
//				Outdegree.add(i, 0);
//			}
//		}
//
//		public ArrayList<Integer> OutDegCal(ArrayList<PairTest>List)
//		{
//			
//		   for(int i=0;i<List.size();i++) {
//			   Outdegree.set(List.get(i).first-'A', Outdegree.get(List.get(i).first-'A')+1);
//
//			}
//		  // printIndeg();
//			return Outdegree;
//			
//		}
//		void printIndeg() 
//		{
//			for(int i=0;i<256;i++) 
//			{
//				System.out.println("\nIn: "+i+": "+Outdegree.get(i));
//			}
//		}
//}

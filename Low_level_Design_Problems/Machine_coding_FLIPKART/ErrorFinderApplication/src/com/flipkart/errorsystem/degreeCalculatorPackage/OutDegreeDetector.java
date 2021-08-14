package com.flipkart.errorsystem.degreeCalculatorPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.flipkart.errorsystem.PairPackage.Pair;

public class OutDegreeDetector {


		ArrayList<Integer>Outdegree= new ArrayList<Integer>(256);
		
		public OutDegreeDetector(){
			for(int i=0;i<256;i++) 
			{
				Outdegree.add(i, 0);
			}
		}

		public ArrayList<Integer> OutDegCal(ArrayList<Pair>List) throws NullPointerException, ArrayIndexOutOfBoundsException
		{
			
		   for(int i=0;i<List.size();i++) {
			   Outdegree.set(List.get(i).first-'A', Outdegree.get(List.get(i).first-'A')+1);

			}
		  // printIndeg();
			return Outdegree;
			
		}
		void printIndeg() 
		{
			for(int i=0;i<256;i++) 
			{
				System.out.println("\nIn: "+i+": "+Outdegree.get(i));
			}
		}
}

package com.flipkart.errorsystem;

import java.util.ArrayList;

import java.util.Scanner;

import com.flipkart.errorsystem.ErrorDetectorPackage.ErrorDetector;
import com.flipkart.errorsystem.PairPackage.Pair;
import com.flipkart.errorsystem.degreeCalculatorPackage.IndegreeDetect;
import com.flipkart.errorsystem.degreeCalculatorPackage.OutDegreeDetector;
import com.flipkart.errorsystem.degreeCalculatorPackage.OutDegreeDetector;

public class Main {

	public static void main(String[] args) 
	    { 
		 

			System.out.println("Enter Number of tuple of the Tree [N]:");

			int[][] AdjacencyArray = new int[256][256];
			
			ArrayList<Pair>List= new ArrayList<Pair>();
			ArrayList<String>ErrorResult = new ArrayList<String>();
			
			Scanner myObj = new Scanner(System.in);
			ErrorDetector errorDetectObject = new ErrorDetector();
			
			int tuples = Integer.parseInt(myObj.nextLine());
			System.out.println("Enter N Tuple of type (root, child):");

			boolean DuplicateErrorFlag=false;
			while(tuples-->0) {
				
				myObj = new Scanner(System.in); 
				String Node = myObj.nextLine();				
				//System.out.println("Node "+Node);
			 	Pair pair = new Pair(Node.charAt(1), Node.charAt(3));
				Integer found= 0;
				for(int i=0;i<List.size();i++) 
				{
					if(List.get(i).first==pair.first&&List.get(i).second==pair.second) {
						if(!DuplicateErrorFlag) {
							ErrorResult.add(errorDetectObject.E2);
							DuplicateErrorFlag=true;
						}
					
						found=1;
					};
				}
				if(found==0) {

					List.add(pair);
				}
				AdjacencyArray[pair.first-'A'][pair.second-'A']=1;
				
			}
			
			// Calling Indegree and OutDegree 
			IndegreeDetect indegObj = new IndegreeDetect();
			ArrayList<Integer>Ind=indegObj.IndegCal(List);
			OutDegreeDetector outDegObj = new OutDegreeDetector();
			ArrayList<Integer>Out= outDegObj.OutDegCal(List);
			
			//System.out.println(Ind);
			//System.out.println(Out);
			
			// Adding in errorList
			errorDetectObject.findErrorMultipleParent(Ind, ErrorResult);
			errorDetectObject.findErrorMoreThantwoChild(Out, ErrorResult);
			
			//multiple root
			ErrorResult=  errorDetectObject.MultipleRootDetector(Ind, ErrorResult, Out);
			ErrorResult=  errorDetectObject.Cycledetector(ErrorResult, AdjacencyArray);
			
			errorDetectObject.printErrors(ErrorResult);
			
			
		    } 
}

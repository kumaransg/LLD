//package com.flipkart.errorsystem.ErrorDetectorPackage;
//
//import java.util.ArrayList;
//
//import com.flipkart.errorsystem.CycleDetectorPackage.CycleDetector;
//
//public class ErrorDetectorTest {
//	
//
//	public String E1 = "More than 2 children";
//	public String E2 = "Duplicate Tuples";
//	public String E3 ="Cycle present";
//	public String E4 ="Multiple roots";
//	public String E5 ="Multiple parent";
//	
//	public ArrayList<String> findErrorMultipleParent(ArrayList<Integer>Ind,ArrayList<String>ErrorRes)
//	{
//		
//		for(int i=0;i<256;i++) 
//		{
//			if(Ind.get(i)>1) 
//			{
//				ErrorRes.add(E5);
//				break;
//			}
//		}
//		return ErrorRes;
//				
//	}
//	
//	public ArrayList<String> findErrorMoreThantwoChild(ArrayList<Integer>Ind,ArrayList<String>ErrorRes)
//	{
//		
//		for(int i=0;i<256;i++) 
//		{
//			if(Ind.get(i)>1) 
//			{
//				ErrorRes.add(E1);
//				break;
//			}
//		}
//		return ErrorRes;
//				
//	}
//	public void printErrors(ArrayList<String>errors) 
//	{
//		System.out.println(errors);
//	}
//	
//	
//	public ArrayList<String> Cycledetector(ArrayList<String>ErrorRes,int[][]adjArray) 
//	{
//	
//		int []visited=new int[256];
//		int []stack=new int[256];
//		int found=0;
//		CycleDetector cycleDetectorObj = new CycleDetector();
//		for(int i=0;i<256;i++) {
//			if(adjArray[0][i]!=0)
//		found=cycleDetectorObj.dfs(i,adjArray,visited,stack);
//		if(found==1) {ErrorRes.add(E3); break;}
//		}
//		return ErrorRes;
//	}
//	
//	
//	public ArrayList<String> MultipleRootDetector(ArrayList<Integer>Indeg, ArrayList<String>ErrorRes, ArrayList<Integer>Out) 
//	{
//		int count=0;
//		for(int i=0;i<Out.size();i++) 
//		{
//			//System.out.print("In:out"+i+"("+Indeg.get(i)+":"+Out.get(i)+")"+"\t");
//			if(Out.get(i)>0 && Indeg.get(i)==0) 
//			{
//				count++;
//			}
//			if(count>1) {ErrorRes.add(E4);break;}
//		}
//		return ErrorRes;
//	}
//}

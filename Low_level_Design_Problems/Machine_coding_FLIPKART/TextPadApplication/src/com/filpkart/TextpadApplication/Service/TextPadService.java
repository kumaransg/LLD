package com.filpkart.TextpadApplication.Service;

import java.util.ArrayList;

import com.flipkart.TextpadApplication.Model.TextPadFunctionAbstract;

public class TextPadService extends TextPadFunctionAbstract {

	 public void display(ArrayList<String>Lines) 
	 {
		 for(int i=0;i<Lines.size();i++) 
		 {
			 if(Lines.get(i)!=null)
			 System.out.println(Lines.get(i));
		 }
	 }
	 
	 public void display(ArrayList<String>Lines,int startline, int endline) 
	 {
		 for(int i=startline-1;i<endline;i++) 
		 {
			 if(Lines.get(i)!=null)
			 System.out.println(Lines.get(i));
		 }
	 }
	 
	 public void insert(ArrayList<String>Lines, String s, int lineNo) 
	 {
		 String textAtLineNo="";
		 if(lineNo<Lines.size()&&Lines.get(lineNo-1)!=null)
		 textAtLineNo = Lines.get(lineNo-1);
		 textAtLineNo+=s;
		 Lines.set(lineNo-1, textAtLineNo);
	 }

	public void delete(ArrayList<String>Lines,int LineNo) 
	{
		Lines.set(LineNo-1, "");
	}
	
	public void deleteInRange(ArrayList<String>Lines,int StartLineNo,int EndLineNo) 
	{
		for(int i=StartLineNo;i<=EndLineNo;i++) 
		{
			Lines.set(i-1, "");
			
		}
	}
	
	public String copy(ArrayList<String>Lines,int startLine, int Endline )
	{
		String tempLines="";
		for(int i=startLine;i<=Endline;i++) 
		{
			tempLines+=Lines.get(i-1);
		}
		return tempLines;
	}
	public void pasteLines(ArrayList<String>Lines,String copiedLines,int LineNo) 
	{
		String temp="";
		if(LineNo<Lines.size()&&Lines.get(LineNo-1)!=null)
			Lines.get(LineNo-1);
		temp+=copiedLines;
		Lines.set(LineNo-1, temp);
	}

}

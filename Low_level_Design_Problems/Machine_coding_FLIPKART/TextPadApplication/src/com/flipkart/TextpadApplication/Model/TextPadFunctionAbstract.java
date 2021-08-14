package com.flipkart.TextpadApplication.Model;

import java.util.ArrayList;

public abstract class TextPadFunctionAbstract {
		public abstract void display(ArrayList<String>Lines); 
		public abstract void display(ArrayList<String>Lines,int startline, int endline); 
		public abstract void insert(ArrayList<String>Lines, String s, int lineNo); 
		public abstract void delete(ArrayList<String>Lines,int LineNo);
		public abstract void deleteInRange(ArrayList<String>Lines,int StartLineNo,int EndLineNo); 
		public abstract String copy(ArrayList<String>Lines,int startLine, int Endline );
		public abstract void pasteLines(ArrayList<String>Lines,String copiedLines,int LineNo);		
	}


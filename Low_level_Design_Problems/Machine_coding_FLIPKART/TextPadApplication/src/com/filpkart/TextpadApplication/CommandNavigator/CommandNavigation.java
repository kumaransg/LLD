package com.filpkart.TextpadApplication.CommandNavigator;

import java.util.ArrayList;

import com.filpkart.TextpadApplication.Service.TextPadService;

public class CommandNavigation {

	public ArrayList<String> PreviousLines;
	public ArrayList<String> Lines;
	public int displaystart;
	public int displayend;
	public int insertLineNo;
	public String insertText;
	public int deleteNo;
	public int deleteRangeStart;
	public int deleteRangeEnd;
	public int copyStart;
	public int copyEnd;
	public int pasteLineNo;
	public String copiedtext;
	
	public CommandNavigation() {
		this.Lines = new ArrayList<String>();
		this.PreviousLines = new ArrayList<String>();
		
	}
	public void cleanVars() 
	{
		displaystart=-1;
		displayend=-1;
		insertLineNo=-1;
		insertText="";
		deleteNo=-1;
		deleteRangeStart=-1;
		deleteRangeEnd=-1;
		copyStart=-1;
		copyEnd=-1;
		pasteLineNo=-1;
		copiedtext="";
		
	}
	public void CommandNavigationFunctionUndo(TextPadService textpadObject,String commandNo) {
		switch(commandNo) 
		{
		
		case "1":
			textpadObject.display(Lines);
			break;

		case "2":

			textpadObject.display(Lines, displaystart, displayend);
			break;

		case "3":
			Lines=PreviousLines;
			break;

		case "4":
			Lines=PreviousLines;
			break;

		case "5":
			Lines=PreviousLines;
			break;

		case "6":
			cleanVars();
			break;

		case "7":
			Lines=PreviousLines;
			break;
	}
	}
	public void CommandNavigationFunctionRedo(TextPadService textpadObject,String commandNo) {
			switch(commandNo) 
			{
			
			case "1":
				textpadObject.display(Lines);
				break;

			case "2":

				textpadObject.display(Lines, displaystart, displayend);
				break;

			case "3":
				this.PreviousLines=(ArrayList<String>)this.Lines.clone();    // tracking previous state of text pad
				System.out.println("I text"+insertText+insertLineNo);
				textpadObject.insert(this.Lines, this.insertText, this.insertLineNo);
				break;
				
			case "4":
				textpadObject.delete(Lines,deleteNo);
				break;

			case "5":
				textpadObject.deleteInRange(Lines, deleteRangeStart, deleteRangeEnd);
				break;

			case "6":
				break;

			case "7":
				textpadObject.pasteLines(Lines, copiedtext, pasteLineNo);
				break;
		}
}
}

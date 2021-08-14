package com.filpkart.TextpadApplication;

import java.util.ArrayList;
import java.util.Scanner;

import com.filpkart.TextpadApplication.CommandNavigator.CommandNavigation;
import com.filpkart.TextpadApplication.Service.TextPadService;


public class TextPadAppClass {


	char loop ='S';
	TextPadService textpadObject;
	CommandNavigation commandNavigationObject = new CommandNavigation();
	public TextPadAppClass() {
		this.textpadObject = new TextPadService();
	}

	void print(ArrayList<String>a) 
	{
		for(int i=0;i<10;i++) 
		{
			System.out.println(a.get(i));
		}
	}
	
	void driver() {
	
	String PreviousCommand="";
	
	
	String copiedLine="";
	
	for(int i=0;i<500;i++) {commandNavigationObject.Lines.add(null);} //textPad 500 lines limit
	
	
	
	while(loop!='E') {
	System.out.println(" 1. display() – to display the entire content\n" +
						"2. display(n, m) – to display from line n to m\n"+
						"3. insert(n, text) – to insert text at line n\n"+
						"4. delete(n) – delete line n\n"+
						"5 .delete(n, m) – delete from line n to m\n"+
						"6. copy(n, m) – copy contents from line n to m to clipboard\n"+
						"7. paste(n) – paste contents from clipboard to line n\n"+
						"8. undo() – undo last command\n"+
						"9. redo() – redo last command\n"+
						"10. Press E for exit"
						);
	Scanner myObj = new Scanner(System.in); 
	String c= myObj.nextLine();
	
	switch(c) 
	{
	
	case "1":
		textpadObject.display(commandNavigationObject.Lines);
		
		commandNavigationObject.cleanVars();
		PreviousCommand="1";
		break;

	case "2":
		int startLine = myObj.nextInt();
		int EndLine = myObj.nextInt();
		textpadObject.display(commandNavigationObject.Lines, startLine, EndLine);
		
		commandNavigationObject.displaystart=startLine;
		commandNavigationObject.displayend=EndLine;
		PreviousCommand="2";
		break;

	case "3":
		commandNavigationObject.PreviousLines=(ArrayList<String>)commandNavigationObject.Lines.clone();    // tracking previous state of text pad
		System.out.println("Enter Line No and Text(space seperated):");
	    
		int LineNo = myObj.nextInt() ;
		String text = myObj.nextLine();
		textpadObject.insert(commandNavigationObject.Lines, text, LineNo);
		commandNavigationObject.cleanVars();
		
		commandNavigationObject.insertText=text;
		commandNavigationObject.insertLineNo=LineNo;
		PreviousCommand="3";
		break;

	case "4":
		commandNavigationObject.PreviousLines=(ArrayList<String>)commandNavigationObject.Lines.clone();    // tracking previous state of text pad

		int DeleteLineNo = myObj.nextInt();
		textpadObject.delete(commandNavigationObject.Lines, DeleteLineNo);
		
		commandNavigationObject.cleanVars();
		commandNavigationObject.deleteNo= DeleteLineNo;
		PreviousCommand="4";
		break;

	case "5":
		commandNavigationObject.PreviousLines=(ArrayList<String>)commandNavigationObject.Lines.clone();    // tracking previous state of text pad

		int StartLineNo =myObj.nextInt();
		int EndLineNo =myObj.nextInt();
		textpadObject.deleteInRange(commandNavigationObject.Lines, StartLineNo, EndLineNo);
		
		commandNavigationObject.cleanVars();
		commandNavigationObject.deleteRangeStart=StartLineNo;
		commandNavigationObject.deleteRangeEnd=EndLineNo;
		
		PreviousCommand="5";
		
		break;

	case "6":
		int CopyStartLineNo=myObj.nextInt();
		int CopyEndLineNo=myObj.nextInt();
		copiedLine=textpadObject.copy(commandNavigationObject.Lines, CopyStartLineNo, CopyEndLineNo);
		
		commandNavigationObject.cleanVars();
		commandNavigationObject.copyStart=CopyStartLineNo;
		commandNavigationObject.copyEnd=CopyEndLineNo;
		PreviousCommand="6";
		
		break;

	case "7":
		commandNavigationObject.PreviousLines=(ArrayList<String>)commandNavigationObject.Lines.clone();    // tracking previous state of text pad
	
		int PasteLineNo= myObj.nextInt();
		textpadObject.pasteLines(commandNavigationObject.Lines, copiedLine, PasteLineNo);
		
		commandNavigationObject.cleanVars();
		commandNavigationObject.copiedtext=copiedLine;
		commandNavigationObject.pasteLineNo=PasteLineNo;
		PreviousCommand="7";
		break;

	case "8":
		commandNavigationObject.CommandNavigationFunctionUndo(textpadObject, PreviousCommand);
		break;

	case "9":
		commandNavigationObject.CommandNavigationFunctionRedo(textpadObject, PreviousCommand);
		break;

	case "E":
		System.out.println("Program is terminating..");
		loop='E';
		break;
		
	}
	}
	}
}

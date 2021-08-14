package project;

import java.util.ArrayList;

public class Folder extends Entry {

	ArrayList<Entry> contents;
	public Folder(String n, int s, String ext) {
		super(n, s, ext);
		contents = new ArrayList<Entry>();
	}
	
	public void setContent(Entry s) {
		contents.add(s);
	}
	
	public ArrayList<Entry> getContent() {
		return contents;
	}
	
	public void removeContent(Entry e) {
		contents.remove(e);
	}
	
	public int numberofFiles() {
		int count = 0;
		// calculates the number of files in a folder.
		return count;
	}
	
	public String getExtention() {
		return extension;
	}

}

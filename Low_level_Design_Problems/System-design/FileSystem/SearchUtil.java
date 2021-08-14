package project;

public class SearchUtil {
	public String name;
	public String ext;
	public int size;
	
	public SearchUtil(String n, String type, int s) {
		this.ext = type;
		this.name = n;
		this.size = s;
	}	
	
	public String searchbyName(String n) {
		// search the system by name
		return name;
	}
	
	public int searchbySize(int size) {
		// search the system by size
		return size;
	}
	
	public String searchbyExt(String type) {
		// search the system by type of extension
		return type;
	}
}

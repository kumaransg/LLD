package project;

import java.util.ArrayList;

// class for searching the files size less than 5mb and .mp4 extension
// LLD OOPS
public class Search {
	
	ArrayList<SearchUtil> target;
	private SearchUtil st;
	
	public Search(String name, String ext, int size) {
		st.ext = ext;
		st.name = name;
		st.size = size;
		target = new ArrayList<SearchUtil>();
	}
	
	public String searchFile(SearchUtil s) {
		String n = null;
		int size = st.searchbySize(s.size);
		if(size < 5) {
			String ext = st.searchbyExt(s.ext);
			if(ext == ".mp4") {
				n = st.searchbyName(s.name);
			}
		}
		return n;
	}
}

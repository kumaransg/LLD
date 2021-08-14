package project;

public abstract class Entry {
	public String name;
	public String extension;
	public int size;
	public long created;
	public long lastaccessed;
	public long lastmodified;
	
	public Entry(String n, int s, String ext) {
		this.name = n;
		this.extension = ext;
		this.size = s;
		created = System.currentTimeMillis();
		lastaccessed = System.currentTimeMillis();
		lastmodified = System.currentTimeMillis();
	}
	

	public void changeName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
	public long getCreatedTime() {
		return created;
	}
	
	public long getLastModifiedTime() {
		return lastmodified;
	}
	
	public long getLastAccessedTime() {
		return lastaccessed;
	}
}

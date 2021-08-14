package project;

public class File extends Entry {
	private String content;
	
	public File(String n, int s, String ext) {
		super(n, s, ext);
	}
	
	public void setContent(String s) {
		content = s;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getExtension() {
		return extension;
	}
}

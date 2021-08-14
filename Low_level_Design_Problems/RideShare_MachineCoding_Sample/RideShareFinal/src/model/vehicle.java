package model;

import java.util.UUID;

public class vehicle {

	private String ids;
	private String owner;
	private String Model;
	private String RegNo;
	
	public vehicle(String owner,String Model,String RegNo) {
		this.ids = UUID.randomUUID().toString();
		this.owner = owner;
		this.Model = Model;
		this.RegNo = RegNo;	
	}

	public String getIds() {
		return ids;
	}

	public String getOwner() {
		return owner;
	}

	public String getCarModel() {
		return Model;
	}

	public String getCarRegNo() {
		return RegNo;
	}
		

}
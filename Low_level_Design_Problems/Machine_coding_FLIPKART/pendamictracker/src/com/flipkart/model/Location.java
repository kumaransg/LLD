package com.flipkart.model;

public class Location {
	
	private String Country;
	private String State;
	private String district;
	
	public String getCountry() {
		return Country;
	}
	public Location(String country, String state, String district) {
		super();
		Country = country;
		State = state;
		this.district = district;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

}

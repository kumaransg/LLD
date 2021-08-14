package com.flipkart.model;

import java.util.ArrayList;

public class Person {
		private String Name;
		private Integer PersonId;
		private Location location;
		private ArrayList<Disease>DiseaseList;

		public Integer getPersonId() {
			return PersonId;
		}
		public void setPersonId(Integer personId) {
			PersonId = personId;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}

		public Person(String name, ArrayList<Disease> diseaseList, Location location) {
			super();
			Name = name;
			DiseaseList = diseaseList;
			this.location = location;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public ArrayList<Disease> getDiseaseList() {
			return DiseaseList;
		}
		public void setDiseaseList(ArrayList<Disease> diseaseList) {
			DiseaseList = diseaseList;
		}
}

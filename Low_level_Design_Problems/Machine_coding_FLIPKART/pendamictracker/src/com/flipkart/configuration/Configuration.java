package com.flipkart.configuration;

import java.util.ArrayList;
import java.util.Date;

import com.flipkart.model.Disease;
import com.flipkart.model.Location;
import com.flipkart.model.Person;
import com.flipkart.repository.Repository;

public class Configuration {
	public ArrayList<Person> init() {
		Date d1 = new Date();
		
		Disease covidd1 = new Disease("COVID-19",d1);
		covidd1.setStatus("Active");
		
		Disease spanishF = new Disease("SF",d1);
		spanishF.setStatus("Cured");
		
		ArrayList diseaseList = new ArrayList<>();
		diseaseList.add(covidd1);
		diseaseList.add(spanishF);
		
		
		Location locationDelhi = new Location("India", "Delhi", "Delhi");
		Location locationUsa = new Location("Usa", "texas", "Austin");
		Location locationBangalore = new Location("India", "Karnataka", "Bangalore");
		

		Person p1Delhi= new  Person("PersonName1", diseaseList, locationDelhi);
		Person p2Delhi= new  Person("PersonName2", diseaseList, locationDelhi);
		Person p3Delhi= new  Person("PersonName3", diseaseList, locationDelhi);
		
		Person p1usa= new  Person("PersonName1", diseaseList, locationUsa);
		Person p2Bangalore= new  Person("PersonName2", diseaseList, locationBangalore);
		Person p3Bangalore= new  Person("PersonName1", diseaseList, locationBangalore);
		
	
		Repository repository = new Repository();
		ArrayList<Person> db = repository.initrepository();
		
		db.add(p1Delhi);
		db.add(p2Delhi);
		db.add(p3Delhi);
		db.add(p1usa);
		db.add(p2Bangalore);
		db.add(p2Bangalore);
		return db;

	}
}

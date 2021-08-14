package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.flipkart.configuration.Configuration;
import com.flipkart.model.Disease;
import com.flipkart.model.Location;
import com.flipkart.model.Person;

public class TrackerService {
	Configuration configObject = new Configuration();
	ArrayList<Person> db =configObject.init();
	
	public void ShowWorldSummary() {
		int Total = 0;
		int Cured = 0;
		int Fatality = 0;
		int Active = 0;
		for(int i=0;i<db.size();i++) 
		{
			Person p = db.get(i);
			ArrayList<Disease>DiseaseList = p.getDiseaseList();
			for(int j=0;j<DiseaseList.size();j++) 
			{
				Total++;
				Disease d = DiseaseList.get(j);
				if(d.getStatus()=="Dead") {Fatality++;}
				else if(d.getStatus()=="Active"){Active++;}
				else if(d.getStatus()=="Cured"){Cured++;}
			}
		}
		System.out.println("Total:"+Total+"\nCured:"+Cured+"\nFatality:"+Fatality+"\nActive:"+Active);

	}
	public void ShowWorldSummaryDiseasesBreakup() {
		HashMap<String,ArrayList<Integer>> mp = new HashMap<>(); 
		
		for(int i=0;i<db.size();i++) 
		{
			Person p = db.get(i);
			ArrayList<Disease>DiseaseList = p.getDiseaseList();
			for(int j=0;j<DiseaseList.size();j++) 
			{
				
				int Cured = 0;
				int Fatality = 0;
				int Active = 0;
				Disease d = DiseaseList.get(j);
				String s = d.getStatus(); 
				if (s=="dead") {Fatality++;}
				else if(s=="Active"){Active++;}
				else if(s=="Cured"){Cured++;}
				ArrayList<Integer> al = new ArrayList<>();
				al.add(Cured);
				al.add(Fatality);
				al.add(Active);
				
				if(mp.containsKey(d.getDiseaseName())) 
				{
					ArrayList<Integer>e = mp.get(d.getDiseaseName());
					if (Cured!=0) {int c= e.get(0);++c;e.set(0, c);}
					if (Fatality!=0) {int f=e.get(1);++f;e.set(1, f);}
					if (Active!=0) {int a=e.get(2);++a;e.set(2, a);}

				}
				else 
				{
					String dname = d.getDiseaseName();
					mp.put(dname, al);			
				}
			}

		}
		Iterator it = mp.entrySet().iterator();
	    
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        ArrayList<Integer>w =(ArrayList<Integer>) pair.getValue();
			System.out.println(pair.getKey()+"\nTotal:"+pair.getValue()+"\nCured:"+w.get(0)+
					"\nFatality:"+w.get(1)+"\nActive:"+w.get(2));

	    }
	}
	
	public void ShowCountryBreakup(String Country) {
		HashMap<String,ArrayList<Integer>> mp = new HashMap<>(); 
		
		for(int i=0;i<db.size();i++) 
		{
			Person p = db.get(i);
			ArrayList<Disease>DiseaseList = p.getDiseaseList();
			for(int j=0;j<DiseaseList.size();j++) 
			{
				
				int Cured = 0;
				int Fatality = 0;
				int Active = 0;
				
				Location l = p.getLocation();

				
				Disease d = DiseaseList.get(j);
				String s = d.getStatus(); 
				
				if (s=="dead") {Fatality++;}
				else if(s=="Active"){Active++;}
				else if(s=="Cured"){Cured++;}
				ArrayList<Integer> al = new ArrayList<>();
				al.add(Cured);
				al.add(Fatality);
				al.add(Active);
				
				if(mp.containsKey(l.getCountry())) 
				{
					ArrayList<Integer>e = mp.get(l.getCountry());
					if (Cured!=0) {int c= e.get(0);++c;e.set(0, c);}
					if (Fatality!=0) {int f=e.get(1);++f;e.set(1, f);}
					if (Active!=0) {int a=e.get(2);++a;e.set(2, a);}

				}
				else 
				{
					String name = l.getCountry();
					mp.put(name, al);			
				}
			}

		}
	    System.out.print(mp);

	}

	public void ShowStateBreakup() {
		HashMap<String,ArrayList<Integer>> mp = new HashMap<>(); 
		
		for(int i=0;i<db.size();i++) 
		{
			Person p = db.get(i);
			ArrayList<Disease>DiseaseList = p.getDiseaseList();
			for(int j=0;j<DiseaseList.size();j++) 
			{
				
				int Cured = 0;
				int Fatality = 0;
				int Active = 0;
				
				Location l = p.getLocation();

				
				Disease d = DiseaseList.get(j);
				String s = d.getStatus(); 
				
				if (s=="dead") {Fatality++;}
				else if(s=="Active"){Active++;}
				else if(s=="Cured"){Cured++;}
				ArrayList<Integer> al = new ArrayList<>();
				al.add(Cured);
				al.add(Fatality);
				al.add(Active);
				
				if(mp.containsKey(l.getState())) 
				{
					ArrayList<Integer>e = mp.get(l.getState());
					if (Cured!=0) {int c= e.get(0);++c;e.set(0, c);}
					if (Fatality!=0) {int f=e.get(1);++f;e.set(1, f);}
					if (Active!=0) {int a=e.get(2);++a;e.set(2, a);}

				}
				else 
				{
					String name = l.getState();
					mp.put(name, al);			
				}
			}

		}
	    System.out.print(mp);

		
	}
	public void cured(String Diesease, String personName) {
		
	}
	public void ShowTrends() {
		
	}

}

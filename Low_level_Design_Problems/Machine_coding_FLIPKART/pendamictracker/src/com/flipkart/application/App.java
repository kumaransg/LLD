package com.flipkart.application;

import com.flipkart.service.TrackerService;

public class App {
	
	public static void main(String []args) {
		TrackerService ts = new TrackerService();
		System.out.println("\nShowWorldSummary\n");
		ts.ShowWorldSummary();
		
		System.out.println("\nShowWorldSummaryDiseasesBreakup\n");
		ts.ShowWorldSummaryDiseasesBreakup();
		
		System.out.println("\nShowCountryBreakup\n");
		ts.ShowCountryBreakup("India");
		System.out.println("\nShowStateBreakup\n");

		ts.ShowStateBreakup();
//		System.out.println("\ShowStateBreakup\n");

//		ts.cured(String Diesease, String personName)	
//		System.out.println("\ShowStateBreakup\n");

	}
}

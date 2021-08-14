package oops3;

import java.util.ArrayList;
import java.util.Collections;

class Movie implements Comparable<Movie> {
	
	private double rating;
	String name;
	private int year;
	
	Movie(String nm, double rt, int yr) {
		this.rating = rt;
		this.name = nm;
		this.year = yr;
	}
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.year - o.year;
	}
	
	public double getRating() { return rating; }
	public String getName()   {  return name; }
	public int getYear()      {  return year;  }
}
public class SortComparable {
	public static void main(String args[]) {
		ArrayList<Movie> list = new ArrayList<Movie> ();
		list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        
        System.out.println("Before sorting : ");
        for(int i = 0; i<list.size();i++) {
        	System.out.println(list.get(i).getName() + "\t" +
        						list.get(i).getRating() + "\t" +
        						 list.get(i).getYear());
        }
        
        Collections.sort(list);
        System.out.println("After sorting : ");
        for(int i = 0; i<list.size();i++) {
        	System.out.println(list.get(i).getName() + "\t" +
        						list.get(i).getRating() + "\t" +
        						 list.get(i).getYear());
        }
 
    }
}

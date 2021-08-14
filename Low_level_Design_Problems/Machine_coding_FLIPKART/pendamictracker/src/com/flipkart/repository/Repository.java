package com.flipkart.repository;

import java.util.ArrayList;

import com.flipkart.model.Person;

public class Repository {

	ArrayList<Person> db;
	public ArrayList<Person> initrepository() {
			return this.db = new ArrayList<>();
		}
}

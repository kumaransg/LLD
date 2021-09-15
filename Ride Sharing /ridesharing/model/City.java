package com.github.akshay.ridesharing.model;

public enum City {
    OTHER("OTHER"),
    HYDERABAD("HYDERABAD"),
    BANGALORE("BANGALORE"),
    MYSORE("MYSORE"),
    MUMBAI("MUMBAI");



    private final String text;

    City(String text) {
        this.text = text;
    }

    public City fromString(String text) {
        for (City city: City.values()) {
            if(city.text.equalsIgnoreCase(text.trim())) {
                return city;
            }
        }
        return null;
    }

}

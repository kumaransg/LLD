package com.github.akshay.ridesharing.model;

public class Vehicle {

    private String id;
    private User user;
    private String name;
    private String regNo;

    public Vehicle(String id, User user, String name, String regNo) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.regNo = regNo;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", regNo='" + regNo + '\'' +
                '}';
    }
}

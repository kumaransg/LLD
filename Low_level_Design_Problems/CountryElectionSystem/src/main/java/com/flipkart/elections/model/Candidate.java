package com.flipkart.elections.model;

import org.omg.PortableInterceptor.INACTIVE;

public class Candidate implements Comparable<Candidate>{
    private String name;
    private Integer votes;

    public Candidate(String name , Integer votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public Integer getVotes(){
        return this.votes;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", votes=" + votes +
                '}';
    }

    @Override
    public int compareTo(Candidate o) {
        return this.getName().compareTo(o.getName());
    }

}

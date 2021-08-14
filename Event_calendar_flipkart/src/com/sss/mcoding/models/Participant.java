package com.sss.mcoding.models;

public abstract class Participant {
    protected String name;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

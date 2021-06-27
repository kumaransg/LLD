package model;

import java.util.UUID;

public class Driver {
    String name;
    String id;

    public Driver(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}

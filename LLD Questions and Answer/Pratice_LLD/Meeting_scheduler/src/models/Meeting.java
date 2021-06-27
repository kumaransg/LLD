package models;

import java.util.ArrayList;
import java.util.UUID;

public class Meeting {
    String id;
    int startTime;
    int endTime;
    String roomID;
    // list of participents

    public Meeting(int startTime, int endTime, String roomID) {
        this.id = UUID.randomUUID().toString();
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomID = roomID;
    }

}

package service;

import models.Room;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchedulerImpl implements Scheduler {

    LinkedHashMap<String, Room> availableRoom;

    public SchedulerImpl() {
        this.availableRoom = new LinkedHashMap<>();
    }

    @Override
    public Room addRoom(String roomName) {
        Room room = new Room(roomName);
        this.availableRoom.put(room.getId(), room);
        return room;
    }

    @Override
    public void removeRoom(Room room) {
        this.availableRoom.remove(room.getId());
    }

    // need iteration go for arrayList
    @Override
    public String bookRoom(int start, int end) {
        for(Map.Entry<String,Room> entry : this.availableRoom.entrySet()){
            if(entry.getValue().bookRoom(start,end)){
                return entry.getValue().getName();
            }
        }
        return "No rooms available";
    }
}

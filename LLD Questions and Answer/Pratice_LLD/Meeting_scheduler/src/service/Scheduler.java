package service;

import models.Room;

// Api's exposed to the outside world
public interface Scheduler {

    public Room addRoom(String roomName);

    public void removeRoom(Room room);

    public String bookRoom(int start, int end);
}

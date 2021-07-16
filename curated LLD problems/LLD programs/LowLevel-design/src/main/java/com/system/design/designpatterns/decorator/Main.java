package com.system.design.designpatterns.decorator;

public class Main {
    public static void main(String[] args) {
        Room room = new DeluxRoom(100);
        room = new RoomHeaterDecorator( room, 10);
        System.out.println(room.getCost());
    }
}

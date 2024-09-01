package com.codeforall.online;

public class Room {
    private boolean freeRoom;
    private int id;
    private RoomType roomType;
    private int price;

    public Room(RoomType roomType, int id) {
        this.freeRoom = true;
        this.roomType = roomType;
        this.id = id;
        this.price = this.roomType.getBasePrice();
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public boolean isAvailable() {
        return this.freeRoom;
    }

    public int getPrice() {
        return this.price;
    }

    public void occupy() {
        this.freeRoom = false;
    }

    public String displayRoomType() {
        return this.roomType.getDisplayName();
    }

    public void vacate() {
        this.freeRoom = true;
    }

    public int getId() {
        return this.id;
    }
}

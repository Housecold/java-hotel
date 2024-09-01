package com.codeforall.online;

public class Person {
    private Hotel hotel;
    private Integer roomId;
    private String name;
    public Bank bank;

    public Person(String name, Bank bank, int firstDeposit) {
        this.name = name;
        this.bank = bank;
        this.depositMoney(firstDeposit);

    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public void depositMoney(int amount) {
        this.bank.deposit(amount);
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean checkOut() {
        this.hotel.checkOut(roomId);
        return true;
    }

    public String getName() {
        return name;
    }

    public int getRoomId() {
        return roomId;
    }

    public boolean checkIn(RoomType roomType) {
        if(this.bank.hasMoney(roomType.getBasePrice())) {
            this.hotel.updateCurrentPerson(this);
            return this.hotel.checkIn(roomType) != 0;
        }
        return false;
    }

    public String toString() {
        if(this.hotel == null) {
            return "Personal info: {Client name: " + this.getName() + ", Hotel: NO HOTEL}";
        } else if(roomId == null) {
            return "Personal info: {Client name: " + this.getName() + ", Hotel: " + this.hotel.getName() + ", Room ID: NO ROOM}";
        } else {
            return "Personal info: {Client name: " + this.getName() + ", Hotel: " + this.hotel.getName() + ", Room ID: " + this.getRoomId() + "}";
        }
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }


}

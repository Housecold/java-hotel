package com.codeforall.online;
import java.util.*;


public class Hotel {
    private String name;
    private Room[] rooms;
    private HashMap<Integer, Person> map;
    private Person currentPerson;

    public Hotel(String name, int numberOfRooms) {
        this.rooms = new Room[numberOfRooms];
        map = new HashMap<>();
        this.name = name;

        for(int i = 0; i < numberOfRooms; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(3) + 1;
            if(randomNumber == 1) {
                rooms[i] = new Room(RoomType.SINGLE, i);
            } else if (randomNumber == 2) {
                rooms[i] = new Room(RoomType.DOUBLE, i);
            } else if (randomNumber == 3) {
                rooms[i] = new Room(RoomType.SUITE, i);
            }
        }
    }

    public void checkOut(int roomId) {
        if(this.map.containsKey(roomId)) {
            this.rooms[roomId].vacate();
            this.map.remove(roomId);
            currentPerson.setHotel(null);
            currentPerson.setRoomId(null);
        }
    }

    public Room[] getRooms() {
        return this.rooms;
    }

    public String getName() {
        return this.name;
    }

    public int checkIn(RoomType roomType) {
        if(this.map.containsValue(currentPerson)) {
            return 0;
        }
        for(Room room : rooms) {
            if(room.getRoomType() == roomType && room.isAvailable()) {
                map.put(room.getId(), currentPerson);
                room.occupy();
                currentPerson.setHotel(this);
                currentPerson.setRoomId(room.getId());
                currentPerson.bank.spend(roomType.getBasePrice());
                return 1;
            }
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel info: {Name: ").append(this.getName()).append(", Rooms available: [");

        for (int i = 0; i < rooms.length; i++) {
            sb.append("{RoomType: ").append(rooms[i].getRoomType()).append("}");
            if (i < rooms.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]}");
        return sb.toString();
    }

    public void updateCurrentPerson(Person person) {
        this.currentPerson = person;
    }
}

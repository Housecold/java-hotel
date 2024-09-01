package com.codeforall.online;

public class Playground {
    public static void main(String[] args) {
        Person person1 = new Person("Daniel", new Bank(), 1000);
        Person person2 = new Person("Ariana", new Bank(), 2000);
        Hotel hotel1 = new Hotel("Pestana", 10);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(hotel1);

        person1.setHotel(hotel1);

        System.out.println(person1);

        person1.checkIn(RoomType.SINGLE);

        System.out.println(person1);

        person1.checkIn(RoomType.DOUBLE);

        System.out.println(person1);

        person1.checkOut();

        System.out.println(person1);

        System.out.println(person1.bank.getMoney());

        person1.depositMoney(1000);

        System.out.println(person1.bank.getMoney());


    }
}

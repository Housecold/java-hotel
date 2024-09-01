package com.codeforall.online;

import java.lang.invoke.LambdaMetafactory;

public class Bank {
    private int money;

    public Bank() {
        this.money = 0;
    }

    public String toString() {
        return "Bank info: {Money: " + this.getMoney() + "}";
    }

    public void deposit(int amount) {
        this.money += amount;
    }

    public void spend(int amount) {
        this.money -= amount;
    }

    public boolean hasMoney(int amount) {
        return amount <= this.money;
    }

    public int getMoney() {
        return this.money;
    }
}

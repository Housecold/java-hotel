package com.codeforall.online;

public enum RoomType {
    SINGLE("Single", 100),
    DOUBLE("Double", 200),
    SUITE("Suite", 300);

    private String displayName;
    private int basePrice;

    private RoomType(String displayName,int basePrice) {
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}


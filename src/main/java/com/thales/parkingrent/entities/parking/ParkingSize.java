package com.thales.parkingrent.entities.parking;

public enum ParkingSize {
    SMALL(10),
    MEDIUM(20),
    LARGE(30);

    private final int priceFactor;

    ParkingSize(int priceFactor) {
        this.priceFactor = priceFactor;
    }

    public int getPriceFactor() {
        return priceFactor;
    }
}

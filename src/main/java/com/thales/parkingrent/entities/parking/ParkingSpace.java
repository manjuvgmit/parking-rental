package com.thales.parkingrent.entities.parking;

public class ParkingSpace {
    private final ParkingSize parkingSize;
    private boolean available;

    public ParkingSpace(ParkingSize parkingSize, boolean available) {
        this.parkingSize = parkingSize;
        this.available = available;
    }

    public ParkingSpace(ParkingSize parkingSize) {
        this(parkingSize, true);
    }

    public ParkingSize getParkingSize() {
        return parkingSize;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setAvailableTrue() {
        setAvailable(true);
    }

    public void setAvailableFalse() {
        setAvailable(false);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParkingSpace{");
        sb.append("parkingSize=").append(parkingSize);
        sb.append(", available=").append(available);
        sb.append('}');
        return sb.toString();
    }
}

package com.thales.parkingrent.entities.parking;

import com.thales.parkingrent.entities.vehicles.Vehicle;

public class ExhibitionStand implements ParkingUsage {
    private final ParkingSize parkingSize;
    private final Vehicle.Value vehicleValue;

    public ExhibitionStand(ParkingSize parkingSize, Vehicle.Value vehicleValue) {
        this.parkingSize = parkingSize;
        this.vehicleValue = vehicleValue;
    }

    @Override
    public ParkingSize getSize() {
        return parkingSize;
    }

    @Override
    public Vehicle.Value getValue() {
        return vehicleValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExhibitionStand{");
        sb.append("parkingSize=").append(parkingSize);
        sb.append(", vehicleValue=").append(vehicleValue);
        sb.append('}');
        return sb.toString();
    }
}

package com.thales.parkingrent.entities.vehicles;

import com.thales.parkingrent.entities.parking.ParkingSize;
import com.thales.parkingrent.entities.parking.ParkingUsage;

public class Car extends AbstractVehicle implements ParkingUsage {
    private final CarType type;
    private final int noOfDoors;

    public Car(CarType type, int noOfDoors, int noOfKms) {
        super(noOfKms);
        this.type = type;
        this.noOfDoors = noOfDoors;
    }
    
    public Car(int noOfKms) {
        this(CarType.CABRIOLETS, 5, noOfKms);
    }

    public CarType getType() {
        return type;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    @Override
    public ParkingSize getSize() {
        return ParkingSize.MEDIUM;
    }

    @Override
    public Value getValue() {
        return getNoOfKms() < 10000 ? Value.COSTLY : getNoOfKms() > 200000 ? Value.CHEAP : Value.MEDIUM;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("type=").append(type);
        sb.append(", noOfDoors=").append(noOfDoors);
        sb.append(", noOfKms=").append(noOfKms);
        sb.append('}');
        return sb.toString();
    }

    public enum CarType {
        CABRIOLETS, MINIVAN, PICKUP
    }
}

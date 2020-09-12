package com.thales.parkingrent.entities.vehicles;

import com.thales.parkingrent.entities.parking.ParkingSize;
import com.thales.parkingrent.entities.parking.ParkingUsage;

import static com.thales.parkingrent.entities.vehicles.Vehicle.Value.*;

public class Truck extends AbstractVehicle implements ParkingUsage {
    private final int length;
    private final int height;
    private final int weight;

    public Truck(int length, int height, int weight, int noOfKms) {
        super(noOfKms);
        this.length = length;
        this.height = height;
        this.weight = weight;
    }
    
    public Truck(int noOfKms) {
        this(0, 0, 0, noOfKms);
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public ParkingSize getSize() {
        return ParkingSize.LARGE;
    }

    @Override
    public Value getValue() {
        return getNoOfKms() < 100000 ? COSTLY : getNoOfKms() > 400000 ? CHEAP : MEDIUM;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck{");
        sb.append("length=").append(length);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", noOfKms=").append(noOfKms);
        sb.append('}');
        return sb.toString();
    }
}

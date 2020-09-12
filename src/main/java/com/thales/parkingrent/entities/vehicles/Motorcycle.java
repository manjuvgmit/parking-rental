package com.thales.parkingrent.entities.vehicles;

import com.thales.parkingrent.entities.parking.ParkingSize;
import com.thales.parkingrent.entities.parking.ParkingUsage;

import static com.thales.parkingrent.entities.vehicles.Vehicle.Value.*;

public class Motorcycle extends AbstractVehicle implements ParkingUsage {
    private final Type type;

    public Motorcycle(Type type, int noOfKms) {
        super(noOfKms);
        this.type = type;
    }
    
    public Motorcycle(int noOfKms) {
        this(Type.CUSTOM, noOfKms);
    }

    public Type getType() {
        return type;
    }

    @Override
    public ParkingSize getSize() {
        return ParkingSize.SMALL;
    }

    @Override
    public Value getValue() {
        return getNoOfKms() < 2000 ? COSTLY : getNoOfKms() > 20000 ? CHEAP : MEDIUM;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Motorcycle{");
        sb.append("type=").append(type);
        sb.append(", noOfKms=").append(noOfKms);
        sb.append('}');
        return sb.toString();
    }

    public enum Type {
        ROADSTER, CUSTOM, TRAIL, RACING
    }
}

package com.thales.parkingrent.entities.vehicles;

public abstract class AbstractVehicle implements Vehicle {

    protected int noOfKms;

    public AbstractVehicle(int noOfKms) {
        this.noOfKms = noOfKms;
    }

    @Override
    public int getNoOfKms() {
        return noOfKms;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractVehicle{");
        sb.append("noOfKms=").append(noOfKms);
        sb.append('}');
        return sb.toString();
    }
}

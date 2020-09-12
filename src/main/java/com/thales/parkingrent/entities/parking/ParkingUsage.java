package com.thales.parkingrent.entities.parking;

import com.thales.parkingrent.entities.vehicles.Vehicle;

public interface ParkingUsage {
    ParkingSize getSize();

    Vehicle.Value getValue();
}

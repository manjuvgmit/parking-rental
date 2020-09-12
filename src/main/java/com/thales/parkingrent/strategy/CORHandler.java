package com.thales.parkingrent.strategy;

import com.thales.parkingrent.entities.parking.ParkingUsage;
import com.thales.parkingrent.entities.parking.ParkingSpace;

import java.util.List;

public interface CORHandler {
    int apply(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces);
}

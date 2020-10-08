package com.thales.parkingrent.entities.parking;

import com.thales.parkingrent.entities.vehicles.Vehicle;

public interface ParkingUsage {
    ParkingSize getSize();

    Vehicle.Value getValue();

    enum Type {
        CAR("Car"), TRUCK("Truck"), MOTORCYCLE("Motorcycle"), EXHIBITION_STAND("ExhibitionStand");

        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}

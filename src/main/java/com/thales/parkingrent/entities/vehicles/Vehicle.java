package com.thales.parkingrent.entities.vehicles;

public interface Vehicle {
    int getNoOfKms();

    enum Value {
        CHEAP(5),
        MEDIUM(10),
        COSTLY(20);

        private final int priceFactor;

        Value(int priceFactor) {
            this.priceFactor = priceFactor;
        }

        public int getPriceFactor() {
            return priceFactor;
        }
    }
}

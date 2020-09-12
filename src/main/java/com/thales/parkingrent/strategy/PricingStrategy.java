package com.thales.parkingrent.strategy;

import com.thales.parkingrent.entities.parking.ParkingSpace;
import com.thales.parkingrent.entities.parking.ParkingUsage;

import java.util.List;

public class PricingStrategy {
    private final CORHandler corHandlerChain;

    public PricingStrategy() {
        // Strategy in the order of execution
        this.corHandlerChain = new DiscountedPriceHandler(new ThirtyPercentHikedPriceHandler(new DoublePriceHandler(null)));
    }

    public int applyPricingStrategy(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces) {
        return corHandlerChain.apply(parkingUsage, basePrice, availableSpaces, totalParkingSpaces);
    }
}

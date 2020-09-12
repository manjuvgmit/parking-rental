package com.thales.parkingrent.strategy;

import com.thales.parkingrent.entities.parking.ParkingSpace;
import com.thales.parkingrent.entities.parking.ParkingUsage;

import java.util.List;

public class ThirtyPercentHikedPriceHandler extends AbstractCORHandler {

    public ThirtyPercentHikedPriceHandler(CORHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean matchCondition(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces) {
        return availableSpaces.size() * 1.0 == totalParkingSpaces.stream().filter(parkingSpace -> parkingSpace.getParkingSize() == parkingUsage.getSize()).count() / 2.0;
    }

    @Override
    protected int applyPricing(int basePrice) {
        return (int) Math.abs(basePrice + basePrice * 0.03);
    }
}

package com.thales.parkingrent.strategy;

import com.thales.parkingrent.entities.parking.ParkingUsage;
import com.thales.parkingrent.entities.parking.ParkingSpace;

import java.util.List;

public class DiscountedPriceHandler extends AbstractCORHandler {

    public DiscountedPriceHandler(CORHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean matchCondition(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces) {
        return availableSpaces.size() == totalParkingSpaces.stream().filter(parkingSpace -> parkingSpace.getParkingSize() == parkingUsage.getSize()).count();
    }

    protected int applyPricing(int basePrice) {
        return (int) Math.abs(basePrice * 1.0 - basePrice * 0.01);
    }

}

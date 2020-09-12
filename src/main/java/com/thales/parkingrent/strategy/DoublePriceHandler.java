package com.thales.parkingrent.strategy;

import com.thales.parkingrent.entities.parking.ParkingSpace;
import com.thales.parkingrent.entities.parking.ParkingUsage;

import java.util.List;

public class DoublePriceHandler extends AbstractCORHandler {

    public DoublePriceHandler(CORHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean matchCondition(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces) {
        return availableSpaces.stream().filter(parkingSpace -> parkingSpace.getParkingSize() == parkingUsage.getSize()).count() == 1;
    }

    @Override
    protected int applyPricing(int basePrice) {
        return basePrice * 2;
    }
}

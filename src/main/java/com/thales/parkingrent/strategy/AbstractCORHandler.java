package com.thales.parkingrent.strategy;

import com.thales.parkingrent.entities.parking.ParkingSpace;
import com.thales.parkingrent.entities.parking.ParkingUsage;

import java.util.List;
import java.util.Objects;

public abstract class AbstractCORHandler implements CORHandler {
    private final CORHandler nextHandler;

    public AbstractCORHandler(CORHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public int apply(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces) {
        return matchCondition(parkingUsage, basePrice, availableSpaces, totalParkingSpaces)
                ? applyPricing(basePrice)
                : passOnToNextHandler(parkingUsage, basePrice, availableSpaces, totalParkingSpaces);
    }

    private int passOnToNextHandler(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces) {
        return Objects.nonNull(nextHandler)
                ? nextHandler.apply(parkingUsage, basePrice, availableSpaces, totalParkingSpaces)
                : basePrice;
    }

    protected abstract boolean matchCondition(ParkingUsage parkingUsage, int basePrice, List<ParkingSpace> availableSpaces, List<ParkingSpace> totalParkingSpaces);

    protected abstract int applyPricing(int basePrice);

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractCORHandler{");
        sb.append("nextHandler=").append(nextHandler);
        sb.append('}');
        return sb.toString();
    }
}

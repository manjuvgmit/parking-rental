package com.thales.parkingrent.entities.parking;

import com.thales.parkingrent.strategy.PricingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingManager {
    private final List<ParkingSpace> parkingSpaces;
    private final PricingStrategy pricingStrategy;

    public ParkingManager(List<ParkingSpace> parkingSpaces, PricingStrategy pricingStrategy) {
        this.parkingSpaces = parkingSpaces;
        this.pricingStrategy = pricingStrategy;
    }

    public int computePrice(ParkingUsage parkingUsage) {
        int basePrice = parkingUsage.getValue().getPriceFactor() * parkingUsage.getSize().getPriceFactor();
        return pricingStrategy.applyPricingStrategy(
                parkingUsage,
                basePrice,
                getAvailableParkingSpaces(parkingUsage),
                getAvailableParkingSpaces()
        );
    }

    public void booking(ParkingUsage parkingUsage) {
        List<ParkingSpace> availableParkingSpaces = getAvailableParkingSpaces(parkingUsage);
        if (!availableParkingSpaces.isEmpty()) {
            availableParkingSpaces.get(0).setAvailableFalse();
        } else {
            System.out.println("Parking is full.");
        }
    }

    public List<ParkingSpace> getAvailableParkingSpaces() {
        return parkingSpaces.stream().filter(ParkingSpace::isAvailable).collect(Collectors.toList());
    }

    public List<ParkingSpace> getAvailableParkingSpaces(ParkingUsage parkingUsage) {
        return getAvailableParkingSpaces().stream().filter(parkingSpace -> parkingSpace.getParkingSize() == parkingUsage.getSize()).collect(Collectors.toList());
    }

    public boolean isParkingFull() {
        return getAvailableParkingSpaces().isEmpty();
    }

    public boolean isParkingFull(ParkingUsage parkingUsage) {
        return !getAvailableParkingSpaces().stream().anyMatch(parkingSpace -> parkingSpace.getParkingSize() == parkingUsage.getSize());
    }

    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaces;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParkingManager{");
        sb.append("parkingSpaces=").append(parkingSpaces);
        sb.append(", pricingStrategy=").append(pricingStrategy);
        sb.append('}');
        return sb.toString();
    }
}

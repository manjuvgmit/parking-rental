/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thales.parkingrent;

import com.google.common.collect.ImmutableSet;
import com.thales.parkingrent.entities.parking.ParkingManager;
import com.thales.parkingrent.entities.parking.ExhibitionStand;
import com.thales.parkingrent.entities.parking.ParkingSize;
import com.thales.parkingrent.entities.parking.ParkingSpace;
import com.thales.parkingrent.entities.vehicles.Vehicle;
import com.thales.parkingrent.gui.ParkingRentFrame;
import com.thales.parkingrent.strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    private static final App instance = new App();
    private final ParkingManager parkingManager;

    public static void main(String[] args) {
        ParkingRentFrame.main(args);
//        ExhibitionStand exhibitionStand = new ExhibitionStand(ParkingSize.SMALL, Vehicle.Value.CHEAP);
//        instance.parkingManager.computePrice(exhibitionStand);
    }

    public App() {
        parkingManager = new ParkingManager(buildParkingSpaces(), new PricingStrategy());
    }

    private static List<ParkingSpace> buildParkingSpaces() {
        List<ParkingSpace> parkingSpaces = new ArrayList<>();
        // Small spaces 15
        addInitialSpaces(parkingSpaces, 15, ParkingSize.SMALL);
        // Medium spaces 10
        addInitialSpaces(parkingSpaces, 10, ParkingSize.MEDIUM);
        // Large spaces 5
        addInitialSpaces(parkingSpaces, 5, ParkingSize.LARGE);
        return parkingSpaces;
    }

    private static void addInitialSpaces(List<ParkingSpace> parkingSpaces, int noOfSpaces, ParkingSize parkingSize) {
        for (int index=0; index < noOfSpaces; index++) {
            parkingSpaces.add(new ParkingSpace(parkingSize));
        }
    }

    public ParkingManager getParkingManager() {
        return parkingManager;
    }
    
    public ImmutableSet<String> getAllUsages() {
        return ImmutableSet.of("Car", "Truck", "Motorcycle", "ExhibitionStand");
    }
    
    public Set<String> getExhibitionStandSizes() {
        return Arrays.stream(ParkingSize.values()).map(ParkingSize::name).collect(Collectors.toSet());
    }
    
    public Set<String> getValueOfExhibitionItem() {
        return Arrays.stream(Vehicle.Value.values()).map(Vehicle.Value::name).collect(Collectors.toSet());
    }
}
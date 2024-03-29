/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thales.parkingrent;

import com.thales.parkingrent.entities.parking.ParkingManager;
import com.thales.parkingrent.entities.parking.ParkingSpace;
import com.thales.parkingrent.entities.vehicles.Car;
import com.thales.parkingrent.entities.vehicles.Motorcycle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingManagerTest {
    ParkingManager parkingManager = new App().getParkingManager();

    @Before
    public void setUp() {
        parkingManager.getAllParkingSpaces().stream().forEach(ParkingSpace::setAvailableTrue);
    }

    @Test
    public void test01() {
        Car car = new Car(Car.CarType.MINIVAN, 5, 10000);
        parkingManager.booking(car);
        assertFalse("Booking should not be full.", parkingManager.isParkingFull());
        for (int index=0; index < 9; index++) {
            parkingManager.booking(car);
        }
        assertTrue("Booking should be full.", parkingManager.isParkingFull(car));
    }

    @Test
    public void test02() {
        Motorcycle motorcycle = new Motorcycle(Motorcycle.Type.RACING, 1500);
        // Amount is 198 because , size medium(20) * vehicle costly(10) = 200 - discount 10% of 200 = 198
        assertEquals("Booking amount should be 180$", 198, parkingManager.computePrice(motorcycle));
    }
}

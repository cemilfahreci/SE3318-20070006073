package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Smoke tests for core rental price calculations and lookups.
 */
public class CarRentalSystemTest {

    /**
     * Tests rental price calculation for a luxury vehicle.
     */
    @Test
    public void testLuxuryVehicleRentalPriceCalculation() {
        LuxuryVehicle car = new LuxuryVehicle("BMW","X5","34ABC01",true,true);
        RentalRecord record = new RentalRecord(car,"Cemil",
                LocalDate.of(2025,5,10), LocalDate.of(2025,5,12));
        assertEquals(3, record.getRentalDuration());
        assertEquals((100.0+20.0+30.0)*3, record.getTotalPrice(), 0.001);
    }

    /**
     * Tests rental price calculation for an economy vehicle.
     */
    @Test
    public void testEconomyVehicleRentalPriceCalculation() {
        EconomyVehicle car = new EconomyVehicle("Toyota","Corolla","35XYZ02",true);
        RentalRecord record = new RentalRecord(car,"Ayse",
                LocalDate.of(2025,5,1), LocalDate.of(2025,5,1));
        assertEquals(1, record.getRentalDuration());
        assertEquals((50.0+10.0)*1, record.getTotalPrice(), 0.001);
    }

    /**
     * Tests findVehicleByLicensePlate lookup.
     */
    @Test
    public void testFindVehicleByLicensePlate() {
        CarRentalSystem system = new CarRentalSystem();
        LuxuryVehicle luxuryCar = new LuxuryVehicle("Mercedes","S500","34ABC123",true,true);
        system.addVehicle(luxuryCar);
        EconomyVehicle economyCar = new EconomyVehicle("BMW","Corolla","34VIP777",false);
        system.addVehicle(economyCar);
        assertEquals(economyCar, system.findVehicleByLicensePlate("34VIP777"));
        assertNull(system.findVehicleByLicensePlate("NOTFOUND"));
    }
}
package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages fleet of vehicles and rental records.
 */
public class CarRentalSystem {

    /** List of available vehicles. */
    private List<VehicleAbstract> vehicles;

    /** List of rental records. */
    private List<RentalRecord> rentalRecords;

    /**
     * Constructs a CarRentalSystem.
     */
    public CarRentalSystem() {
        vehicles = new ArrayList<>();
        rentalRecords = new ArrayList<>();
    }

    /**
     * Adds a vehicle to the fleet.
     *
     * @param vehicle vehicle to add
     */
    public void addVehicle(VehicleAbstract vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Finds a vehicle by its license plate.
     *
     * @param licensePlate plate to search
     * @return vehicle or null if not found
     */
    public VehicleAbstract findVehicleByLicensePlate(String licensePlate) {
        for (VehicleAbstract v : vehicles) {
            if (v.getLicensePlate().equals(licensePlate)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Rents a vehicle to a customer.
     *
     * @param renterId     customer ID
     * @param licensePlate plate of vehicle
     * @param startDate    rental start
     * @param endDate      rental end
     * @return created rental record
     */
    public RentalRecord rentVehicle(String renterId, String licensePlate, LocalDate startDate, LocalDate endDate) {
        VehicleAbstract vehicle = findVehicleByLicensePlate(licensePlate);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found");
        }
        RentalRecord record = new RentalRecord(vehicle, renterId, startDate, endDate);
        rentalRecords.add(record);
        return record;
    }

    /**
     * Returns rental history for a customer.
     *
     * @param renterId customer ID
     * @return list of rental records
     */
    public List<RentalRecord> getRentalHistoryForCustomer(String renterId) {
        return rentalRecords.stream()
                .filter(r -> r.getRenterId().equals(renterId))
                .collect(Collectors.toList());
    }

    /**
     * Returns all economy vehicles.
     *
     * @return list of economy vehicles
     */
    public List<EconomyVehicle> getEconomyVehicles() {
        return vehicles.stream()
                .filter(v -> v instanceof EconomyVehicle)
                .map(v -> (EconomyVehicle) v)
                .collect(Collectors.toList());
    }

    /**
     * Returns all luxury vehicles.
     *
     * @return list of luxury vehicles
     */
    public List<LuxuryVehicle> getLuxuryVehicles() {
        return vehicles.stream()
                .filter(v -> v instanceof LuxuryVehicle)
                .map(v -> (LuxuryVehicle) v)
                .collect(Collectors.toList());
    }

    /**
     * Returns all vehicles.
     *
     * @return list of all vehicles
     */
    public List<VehicleAbstract> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    /**
     * Returns all rental records.
     *
     * @return list of all rentals
     */
    public List<RentalRecord> getAllRentalRecords() {
        return new ArrayList<>(rentalRecords);
    }
}
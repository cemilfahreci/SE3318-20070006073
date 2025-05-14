package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a rental record for a vehicle.
 */
public class RentalRecord {

    /** The rented vehicle. */
    private VehicleAbstract vehicle;

    /** Identifier of the renter. */
    private String renterId;

    /** Start date of the rental. */
    private LocalDate startDate;

    /** End date of the rental. */
    private LocalDate endDate;

    /** Total price of this rental. */
    private double totalPrice;

    /**
     * Constructs a RentalRecord.
     *
     * @param vehicle   the vehicle being rented
     * @param renterId  customer identifier
     * @param startDate rental start date
     * @param endDate   rental end date
     */
    public RentalRecord(VehicleAbstract vehicle, String renterId, LocalDate startDate, LocalDate endDate) {
        this.vehicle = vehicle;
        this.renterId = renterId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = calculateTotalPrice();
    }

    /**
     * Returns the rental duration in days.
     *
     * @return number of rental days
     */
    public int getRentalDuration() {
        return (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    /**
     * Calculates the total price based on duration and vehicle rates.
     *
     * @return total rental price
     */
    public double calculateTotalPrice() {
        return vehicle.calculateRentalPrice(getRentalDuration());
    }

    /**
     * Returns the total price.
     *
     * @return total rental price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets a new end date and updates total price.
     *
     * @param endDate new rental end date
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        this.totalPrice = calculateTotalPrice();
    }

    /**
     * Returns the vehicle.
     *
     * @return rented vehicle
     */
    public VehicleAbstract getVehicle() {
        return vehicle;
    }

    /**
     * Returns the renter identifier.
     *
     * @return renter ID
     */
    public String getRenterId() {
        return renterId;
    }

    /**
     * Returns the start date.
     *
     * @return rental start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Returns the end date.
     *
     * @return rental end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }
}
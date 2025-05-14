package org.example;

/**
 * Represents an abstract vehicle with core attributes and pricing.
 */
public abstract class VehicleAbstract {

    /** Brand of the vehicle. */
    private String brand;

    /** Model of the vehicle. */
    private String model;

    /** License plate of the vehicle. */
    private String licensePlate;

    /** Base rental price per day for the vehicle. */
    private double baseRentalPrice;

    /**
     * Constructs a VehicleAbstract.
     *
     * @param brand            brand of the vehicle
     * @param model            model of the vehicle
     * @param licensePlate     license plate of the vehicle
     * @param baseRentalPrice  base daily rental price
     */
    public VehicleAbstract(String brand, String model, String licensePlate, double baseRentalPrice) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.baseRentalPrice = baseRentalPrice;
    }

    /**
     * Returns the brand.
     *
     * @return brand of the vehicle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the model.
     *
     * @return model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the license plate.
     *
     * @return license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets the license plate.
     *
     * @param licensePlate new license plate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Returns the base rental price per day.
     *
     * @return base daily rental price
     */
    public double getBaseRentalPrice() {
        return baseRentalPrice;
    }

    /**
     * Sets the base rental price per day.
     *
     * @param baseRentalPrice new base price
     */
    public void setBaseRentalPrice(double baseRentalPrice) {
        this.baseRentalPrice = baseRentalPrice;
    }

    /**
     * Calculates total rental price over given days.
     *
     * @param days number of rental days
     * @return total price for days
     */
    public abstract double calculateRentalPrice(int days);
}
package org.example;

/**
 * Represents a luxury vehicle with optional GPS and leather seats.
 */
public class LuxuryVehicle extends VehicleAbstract {

    /** Default base rental price for luxury vehicles. */
    private static final double BASE_RENTAL_PRICE = 100.0;

    /** Additional GPS price per day. */
    private static final double GPS_PRICE = 20.0;

    /** Additional leather seats price per day. */
    private static final double LEATHER_SEATS_PRICE = 30.0;

    /** Indicates if the vehicle has GPS. */
    private boolean hasGps;

    /** Indicates if the vehicle has leather seats. */
    private boolean hasLeatherSeats;

    /**
     * Constructs a LuxuryVehicle.
     *
     * @param brand           vehicle brand
     * @param model           vehicle model
     * @param licensePlate    vehicle license plate
     * @param hasGps          whether GPS is included
     * @param hasLeatherSeats whether leather seats are included
     */
    public LuxuryVehicle(String brand, String model, String licensePlate, boolean hasGps, boolean hasLeatherSeats) {
        super(brand, model, licensePlate, BASE_RENTAL_PRICE);
        this.hasGps = hasGps;
        this.hasLeatherSeats = hasLeatherSeats;
    }

    /**
     * Calculates rental price including extras.
     *
     * @param days number of rental days
     * @return total rental price
     */
    @Override
    public double calculateRentalPrice(int days) {
        double daily = getBaseRentalPrice();
        if (hasGps) {
            daily += GPS_PRICE;
        }
        if (hasLeatherSeats) {
            daily += LEATHER_SEATS_PRICE;
        }
        return daily * days;
    }

    /**
     * Indicates if GPS is present.
     *
     * @return true if GPS included
     */
    public boolean hasGps() {
        return hasGps;
    }

    /**
     * Sets GPS inclusion.
     *
     * @param hasGps true to include GPS
     */
    public void setHasGps(boolean hasGps) {
        this.hasGps = hasGps;
    }

    /**
     * Indicates if leather seats are present.
     *
     * @return true if leather seats included
     */
    public boolean hasLeatherSeats() {
        return hasLeatherSeats;
    }

    /**
     * Sets leather seats inclusion.
     *
     * @param hasLeatherSeats true to include leather seats
     */
    public void setHasLeatherSeats(boolean hasLeatherSeats) {
        this.hasLeatherSeats = hasLeatherSeats;
    }
}
package org.example;

/**
 * Represents an economy vehicle with optional hybrid feature.
 */
public class EconomyVehicle extends VehicleAbstract {

    /** Default base rental price for economy vehicles. */
    private static final double BASE_RENTAL_PRICE = 50.0;

    /** Additional hybrid price per day. */
    private static final double HYBRID_PRICE = 10.0;

    /** Indicates if the vehicle is hybrid. */
    private boolean isHybrid;

    /**
     * Constructs an EconomyVehicle.
     *
     * @param brand         vehicle brand
     * @param model         vehicle model
     * @param licensePlate  vehicle license plate
     * @param isHybrid      whether hybrid feature is included
     */
    public EconomyVehicle(String brand, String model, String licensePlate, boolean isHybrid) {
        super(brand, model, licensePlate, BASE_RENTAL_PRICE);
        this.isHybrid = isHybrid;
    }

    /**
     * Calculates rental price including hybrid extra.
     *
     * @param days number of rental days
     * @return total rental price
     */
    @Override
    public double calculateRentalPrice(int days) {
        double daily = getBaseRentalPrice();
        if (isHybrid) {
            daily += HYBRID_PRICE;
        }
        return daily * days;
    }

    /**
     * Indicates if hybrid is enabled.
     *
     * @return true if hybrid included
     */
    public boolean isHybrid() {
        return isHybrid;
    }

    /**
     * Sets hybrid feature.
     *
     * @param isHybrid true to include hybrid
     */
    public void setHybrid(boolean isHybrid) {
        this.isHybrid = isHybrid;
    }
}
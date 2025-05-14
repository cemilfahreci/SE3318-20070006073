package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * CLI entry point for the car rental system.
 */
public class Main {

    /**
     * Application entry.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        initializeSampleVehicles(system);
        runUserInterface(system);
    }

    /**
     * Adds sample vehicles to the system.
     *
     * @param system rental system instance
     */
    private static void initializeSampleVehicles(CarRentalSystem system) {
        system.addVehicle(new LuxuryVehicle("BMW", "5 Series", "34ABC01", true, true));
        system.addVehicle(new LuxuryVehicle("Mercedes", "E-Class", "34DEF02", false, true));
        system.addVehicle(new EconomyVehicle("Toyota", "Corolla", "35XYZ03", true));
        system.addVehicle(new EconomyVehicle("Honda", "Civic", "35GHI04", false));
    }

    /**
     * Runs the console UI loop.
     *
     * @param system rental system instance
     */
    private static void runUserInterface(CarRentalSystem system) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.println("1. List all vehicles");
            System.out.println("2. List economy vehicles");
            System.out.println("3. List luxury vehicles");
            System.out.println("4. Rent a vehicle");
            System.out.println("5. View rental history");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    for (VehicleAbstract v : system.getAllVehicles()) {
                        System.out.println(v.getBrand() + " " + v.getModel() + " - " + v.getLicensePlate());
                    }
                    break;
                case 2:
                    for (EconomyVehicle v : system.getEconomyVehicles()) {
                        System.out.println(v.getBrand() + " " + v.getModel() + " - " + v.getLicensePlate());
                    }
                    break;
                case 3:
                    for (LuxuryVehicle v : system.getLuxuryVehicles()) {
                        System.out.println(v.getBrand() + " " + v.getModel() + " - " + v.getLicensePlate());
                    }
                    break;
                case 4:
                    System.out.print("Customer ID: ");
                    String id = scanner.nextLine();
                    System.out.print("License plate: ");
                    String plate = scanner.nextLine();
                    System.out.print("Start date (yyyy-MM-dd): ");
                    LocalDate start = LocalDate.parse(scanner.nextLine(), fmt);
                    System.out.print("End date (yyyy-MM-dd): ");
                    LocalDate end = LocalDate.parse(scanner.nextLine(), fmt);
                    try {
                        RentalRecord rec = system.rentVehicle(id, plate, start, end);
                        System.out.println("Total price: $" + rec.getTotalPrice());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Customer ID: ");
                    String rid = scanner.nextLine();
                    List<RentalRecord> hist = system.getRentalHistoryForCustomer(rid);
                    for (RentalRecord r : hist) {
                        System.out.println(r.getVehicle().getBrand() + " " + r.getVehicle().getModel()
                                + " | " + r.getStartDate() + " to " + r.getEndDate()
                                + " | Days: " + r.getRentalDuration()
                                + " | Total: $" + r.getTotalPrice());
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
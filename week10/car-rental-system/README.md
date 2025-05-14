# Car Rental System

This project represents a car rental system for a company. Customers can rent luxury or economy cars.

## Project Features

### Vehicle Types and Features
- **All Vehicles**: Have brand, model, and license plate information.
- **Luxury Vehicles**: Base rental price is $100 per day. Additional features:
  - GPS: Additional $20 per day
  - Leather Seats: Additional $30 per day
- **Economy Vehicles**: Base rental price is $50 per day. Additional features:
  - Hybrid: Additional $10 per day

### Rental System
- Customers can rent vehicles for specific date ranges.
- Rental records store vehicle information, renter information, rental dates, and total price.
- The total price is calculated as: base price + additional feature prices x number of days.

## Project Structure

The project consists of the following classes:

1.  **`VehicleAbstract`**: Base abstract class for all vehicles.
2.  **`LuxuryVehicle`**: Class representing luxury vehicles.
3.  **`EconomyVehicle`**: Class representing economy vehicles.
4.  **`RentalRecord`**: Class representing a rental record.
5.  **`CarRentalSystem`**: Class managing the car rental system.
6.  **`Main`**: Main class of the application and user interface.

## Quality Standards

The project was developed according to the following quality standards:

### Naming Conventions
- Class names are in UpperCamelCase format.
- Method and variable names are in lowerCamelCase format.
- Constant names are in UPPER_CASE format.

### Abstract Class/Interface Naming Convention
- Abstract class or interface names must end with "Abstract".

### Abstraction Level
- The maximum allowed coupling in class data abstraction coupling is 5.

### Class Complexity
- The maximum allowed complexity in Class fan-out complexity is 10.

### Method Count
- The number of methods per class is limited to a maximum of 50.


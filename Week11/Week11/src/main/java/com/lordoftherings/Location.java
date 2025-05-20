package com.lordoftherings;

/**
 * Represents a location on the map.
 */
public class Location {
    private String name;
    private double x;
    private double y; // Javadoc added, complies with Checkstyle

    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return name + " at (" + x + ", " + y + ")";
    }
}

package com.example.mitrakiciman.haysol;

import java.util.*;
public class Location {
    private double latitude;
    private double longitude;
    private int id;
    private double area;
    private double energy;
    public Location() {

    }

    public void setLatitude(double l) {
        latitude = l;
    }

    public void setLongitude(double l) {
        longitude = l;
    }

    public void setID(int i) {
        id = i;
    }

    public void setArea(double a) {
        area = a;
    }

    public int getID() {
        return id;
    }

    public void setEnergy() {
        energy = area / 1.635481 * 250;
    }

    public double getArea() {
        return area;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getEnergy() {
        if (energy == 0.0){ setEnergy();}
        return energy;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Location)) {
            return false;
        }
        Location l = (Location) other;
        return this.id == l.id;
    }

    public int hashCode() {
        return id;
    }

    public int compareTo(Location l) {
        return this.id - l.id;
    }

    public String toString() {
        return Integer.toString(id) + ", " + Double.toString(latitude ) + ", " + Double.toString(longitude) + ", " + Double.toString(area);
    }
}

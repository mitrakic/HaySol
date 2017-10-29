package com.example.mitrakiciman.haysol;

public class Coordinate {
    private double myX;
    private double myY;
    public Coordinate(double x, double y) {
        myX = x;
        myY = y;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Coordinate)) {
            return false;
        }
        Coordinate l = (Coordinate) other;
        return Math.abs(this.myX - l.myX) < 0.00001 && Math.abs(this.myY - l.myY) < 0.00001;
    }

    public int hashCode() {
        return (int)(myX*17*10e3 + myY*31*10e3);
    }

    public String toString() {
        return myX + ", " + myY;
    }
}

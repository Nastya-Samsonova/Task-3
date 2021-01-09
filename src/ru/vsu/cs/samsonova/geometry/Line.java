package ru.vsu.cs.samsonova.geometry;

public class Line {
    public double k;
    public double b;

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public boolean isPointAboveLine(Point point) {
        return point.y > k * point.x + b;
    }
}

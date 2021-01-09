package ru.vsu.cs.samsonova.geometry;

public class Circle {
    public double x0;
    public double y0;
    public double radius;

    public Circle(double x0, double y0, double radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    public boolean isPointInsideCircle(Point point) {
        return Math.pow(radius, 2) >= Math.pow(point.x - x0, 2) + Math.pow(point.y - y0, 2);
    }
}

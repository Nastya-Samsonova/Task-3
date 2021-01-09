package ru.vsu.cs.samsonova.geometry;

public class Parabola {
    public double a;
    public double b;
    public double c;

    public Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isPointAboveParabola(Point point) {
        return point.y > a * point.x * point.x + b * point.x + c;
    }
}

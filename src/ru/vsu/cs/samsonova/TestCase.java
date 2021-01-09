package ru.vsu.cs.samsonova;

import ru.vsu.cs.samsonova.geometry.*;

public class TestCase {
    private final double x;
    private final double y;
    SimpleColor rightColor;

    public TestCase(double x, double y, SimpleColor rightColor) {
        this.x = x;
        this.y = y;
        this.rightColor = rightColor;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public SimpleColor getRightColor() {
        return rightColor;
    }
}
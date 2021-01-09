package ru.vsu.cs.samsonova;

import ru.vsu.cs.samsonova.geometry.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Picture picture = new Picture(new Line(-1, -1),
                new Circle(2, -2, 2),
                new Parabola(-0.0625, 0.375, -6.6875));
        if (runTests(picture)) {
            startProgram(picture);
        } else {
            System.out.println("The program does not work correctly");
        }
    }

    private static void startProgram(Picture picture) {
        double x = readPoint("x = ");
        double y = readPoint("y = ");
        if (x >= -10 && x <= 10 && y >= -10 && y <= 10) {
            Point point = new Point(x, y);
            SimpleColor color = picture.getColor(point);
            printColorForPoint(x, y, color);
        } else {
            System.out.println("Error was made in the specified shape parameters");
        }
    }

    private static void printColorForPoint(double x, double y, SimpleColor color) {
        System.out.print("Color for present point: (" + x + "," + y + ") --> " + color);
    }

    private static boolean runTests(Picture picture) {
        TestCase[] tests = {new TestCase(3, -3, SimpleColor.YELLOW),
                new TestCase(5, -5, SimpleColor.ORANGE),
                new TestCase(1, -3, SimpleColor.BLUE),
                new TestCase(-4, 2, SimpleColor.GRAY),
                new TestCase(-2, 5, SimpleColor.ORANGE),
                new TestCase(6, -8, SimpleColor.BLUE),
                new TestCase(2, 0, SimpleColor.YELLOW),
                new TestCase(0, -2, SimpleColor.BLUE),
                new TestCase(-5, -7, SimpleColor.GRAY),
                new TestCase(7, 7, SimpleColor.ORANGE)};
        boolean testResult = true;
        for (TestCase testing : tests) {
            Point point = new Point(testing.getX(), testing.getY());
            SimpleColor color = picture.getColor(point);
            SimpleColor rightColor = testing.getRightColor();
            if (color == rightColor) {
                printTestCase(point, color, rightColor, "Correct result");
            } else {
                printTestCase(point, color, rightColor, "Incorrect result");
                testResult = false;
            }
        }
        return testResult;
    }

    private static void printTestCase(Point point, SimpleColor color, SimpleColor rightColor, String testResult) {
        System.out.println("Result of tests: (" + point.getX() + ";" + point.getY() + ") --> " + color +
                ", right color --> " + rightColor + "," + testResult);
    }

    private static double readPoint(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter coordinate for point %s", name);
        return scanner.nextDouble();
    }
}
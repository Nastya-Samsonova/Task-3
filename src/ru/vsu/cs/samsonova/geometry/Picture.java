package ru.vsu.cs.samsonova.geometry;

public class Picture {
    private final Line line;
    private final Circle circle;
    private final Parabola parabola;

    public Picture(Line line, Circle circle, Parabola parabola) {
        this.line = line;
        this.circle = circle;
        this.parabola = parabola;
    }

    public SimpleColor getColor(Point point) {
        if (isPointInOrangeArea(point)) {
            return SimpleColor.ORANGE;
        }
        if (isPointInGreyArea(point)) {
            return SimpleColor.GRAY;
        }
        if (isPointInYellowArea(point)) {
            return SimpleColor.YELLOW;
        }
        if (isPointInBlueArea(point)) {
            return SimpleColor.BLUE;
        }
        return SimpleColor.ORANGE;
    }

    private boolean isPointInOrangeArea(Point point) {
        return line.isPointAboveLine(point) && !circle.isPointInsideCircle(point) && parabola.isPointAboveParabola(point);
    }

    private boolean isPointInGreyArea(Point point) {
        return !line.isPointAboveLine(point) && !circle.isPointInsideCircle(point) && parabola.isPointAboveParabola(point);
    }

    private boolean isPointInYellowArea(Point point) {
        return (line.isPointAboveLine(point) && circle.isPointInsideCircle(point) && parabola.isPointAboveParabola(point)) ||
                (line.isPointAboveLine(point) && circle.isPointInsideCircle(point) && !parabola.isPointAboveParabola(point)) ||
                (!line.isPointAboveLine(point) && circle.isPointInsideCircle(point) && !parabola.isPointAboveParabola(point));
    }

    private boolean isPointInBlueArea(Point point) {
        return (!line.isPointAboveLine(point) && circle.isPointInsideCircle(point) && parabola.isPointAboveParabola(point)) ||
                (line.isPointAboveLine(point) && !circle.isPointInsideCircle(point) && !parabola.isPointAboveParabola(point)) ||
                (!line.isPointAboveLine(point) && parabola.isPointAboveParabola(point)) ||
                (!line.isPointAboveLine(point) && !parabola.isPointAboveParabola(point) && !circle.isPointInsideCircle(point));
    }
}

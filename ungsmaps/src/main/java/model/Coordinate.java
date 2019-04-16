package model;

import com.google.common.base.Objects;

import java.awt.*;

public class Coordinate {

    private Point point;

    public Coordinate(Integer x, Integer y) {
        if (x == null || y == null) {
            throw new RuntimeException("Value point is invalid to asign in coordinate.");
        }
        this.point = new Point(x, y);
    }

    public Double getX() {
        return point.getX();
    }

    public Double getY() {
        return point.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equal(point, that.point);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(point);
    }

}
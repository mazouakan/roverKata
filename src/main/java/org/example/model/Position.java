package org.example.model;

public class Position {
    private Coordinate coordinate;

    private Direction direction;

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return coordinate.getX() + " " + coordinate.getY() + " " + direction.getValue();
    }
}

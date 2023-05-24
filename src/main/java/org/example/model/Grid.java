package org.example.model;

import java.util.Collections;
import java.util.List;

import static org.example.model.Direction.*;
import static org.example.model.Direction.WEST;

public class Grid {

    private int width;
    private int height;

    private List<Coordinate> deployedRovers = Collections.emptyList();

    public List<Coordinate> updateDeployedRovers(Coordinate coordinate){
        deployedRovers.add(coordinate);
        return deployedRovers;
    }

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Grid(int width, int height, List<Coordinate> deployedRovers) {
        this.width = width;
        this.height = height;
        this.deployedRovers = deployedRovers;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public Position nextPosition(Position position) {

        Coordinate coordinate = position.getCoordinate();
        if(position.getDirection() == NORTH)
            if((coordinate.getY() + 1) <= height ) {
                Coordinate nextCoordinate = new Coordinate(coordinate.getX(),coordinate.getY() + 1);
                if(!deployedRovers.contains(nextCoordinate))
                    position.getCoordinate().setY(coordinate.getY() + 1);
            }
        if(position.getDirection() == EAST)
            if((coordinate.getX() + 1) <= width) {
                Coordinate nextCoordinate = new Coordinate(coordinate.getX() + 1,coordinate.getY() );
                if(!deployedRovers.contains(nextCoordinate))
                    position.getCoordinate().setX(coordinate.getX() + 1);
            }
        if(position.getDirection() == SOUTH)
            if((coordinate.getY() -1) >= 0) {
                Coordinate nextCoordinate = new Coordinate(coordinate.getX(),coordinate.getY() - 1);
                if(!deployedRovers.contains(nextCoordinate))
                    position.getCoordinate().setY(coordinate.getY() - 1);
            }
        if(position.getDirection() == WEST)
            if((coordinate.getX() - 1) >= 0) {
                Coordinate nextCoordinate = new Coordinate(coordinate.getX() - 1, coordinate.getY() );
                if(!deployedRovers.contains(nextCoordinate))
                    position.getCoordinate().setX(coordinate.getX() - 1);
            }
        return position;
    }
}

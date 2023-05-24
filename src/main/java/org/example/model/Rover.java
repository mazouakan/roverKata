package org.example.model;

import static org.example.model.Direction.*;

public class Rover {
    Direction direction;
    Coordinate coordinate;

    private Grid grid;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String explore(String initialPosition, String commands) {

        String currentPosition = initialPosition;
        Position position = getCurretPosition(initialPosition);
        for (char c : commands.toCharArray()) {
             direction = currentDirection(currentPosition);
             coordinate = currentCoordinate(currentPosition);
            if (c == 'R') {
                 rotateRight(position);
            }
            if(c == 'L') {
                rotateLeft(position);
            }
            if(c == 'M'){
                position = grid.nextPosition(position);

            }
        }

        return position.toString();
    }


    private Position getCurretPosition(String initialPosition) {
        Coordinate coordinate1 = currentCoordinate(initialPosition);
        Direction direction1 = currentDirection(initialPosition);
        return new Position(coordinate1,direction1);
    }

    private Coordinate currentCoordinate(String currentPosition) {
        int x,y;
        x = Integer.parseInt(String.valueOf(currentPosition.charAt(0)));

        y = Integer.parseInt(String.valueOf(currentPosition.charAt(2)));
        coordinate = new Coordinate(x,y);
        return coordinate;
    }

    private Direction currentDirection(String initialPosition) {
        char initialDirection = initialPosition.charAt(initialPosition.length() -1);
        if (initialDirection == 'N') return NORTH;
        else if (initialDirection == 'E') return Direction.EAST;
        else if (initialDirection == 'S') return Direction.SOUTH;
        else return Direction.WEST;
    }


    private Position rotateRight(Position position){
        char right = position.getDirection().getRight();
        for(Direction direction : values()){
            if(direction.getValue() == right)
                position.setDirection(direction);
        }
        return position;
    }
    private Position rotateLeft(Position position){
        char left = position.getDirection().getLeft();
        for(Direction direction : values()){
            if(direction.getValue() == left)
                position.setDirection(direction);
        }
        return position;
    }


}

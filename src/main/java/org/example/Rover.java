package org.example;

import static org.example.Direction.*;

public class Rover {
    Direction direction;
    Coordinate coordinate;
    public String explore(String initialPosition, String commands) {

        String currentPosition = initialPosition;
        Position position = getCurretPosition(initialPosition);
        for (char c : commands.toCharArray()) {
             direction = currentDirection(currentPosition);
             coordinate = currentCoordinate(currentPosition);
            if (c == 'R') {
                //currentPosition = turnRight(currentPosition,direction);
                rotateRight(position);
            }
            if(c == 'L') {
               // currentPosition = turnLeft(currentPosition,direction);
                rotateLeft(position);
            }
            if(c == 'M'){
                //currentPosition = move(currentPosition,direction, coordinate);
                move(position);
            }
        }
        //return  currentPosition;
        return position.toString();
    }

    private Position getCurretPosition(String initialPosition) {
        Coordinate coordinate1 = currentCoordinate(initialPosition);
        Direction direction1 = currentDirection(initialPosition);
        return new Position(coordinate1,direction1);
    }

    private Coordinate currentCoordinate(String currentPosition) {
        int x,y;
        x = Integer.valueOf(currentPosition.charAt(0));
        y = Integer.valueOf(currentPosition.charAt(2));
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

   /* private String turnRight(String currentPosition, Direction currentDirection){
        return currentPosition.replace(currentDirection.getValue(), currentDirection.getRight());
    }*/

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
   /* private String turnLeft(String currentPosition, Direction currentDirection) {
        return currentPosition.replace(currentDirection.getValue(), currentDirection.getLeft());
    }*/
   /* private String move(String currentPosition, Direction direction, Coordinate coordinate) {
        if(direction == NORTH)
        currentPosition =  currentPosition.replace((char)coordinate.getY(), (char)(coordinate.getY() + 1));
        else if(direction == EAST)
            currentPosition =  currentPosition.replace((char)coordinate.getX(), (char)(coordinate.getX() + 1));
        else if(direction == SOUTH)
            currentPosition =  currentPosition.replace((char)coordinate.getY(), (char)(coordinate.getY() - 1));
        else if(direction == WEST)
            currentPosition =  currentPosition.replace((char)coordinate.getX(), (char)(coordinate.getX() - 1));
        return currentPosition;
    }*/
    private Position move(Position position){
        Coordinate coordinate = position.getCoordinate();
        if(position.getDirection() == NORTH)
            position.getCoordinate().setY(coordinate.getY() + 1);
        if(position.getDirection() == EAST)
            position.getCoordinate().setY(coordinate.getX() + 1);
        if(position.getDirection() == SOUTH)
            position.getCoordinate().setY(coordinate.getY() - 1);
        if(position.getDirection() == WEST)
            position.getCoordinate().setY(coordinate.getX() - 1);
        return position;
    }
}

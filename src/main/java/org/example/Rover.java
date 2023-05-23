package org.example;

public class Rover {
    public String explore(String initialPosition, String commands) {


        String currentPosition = initialPosition;
        for (char c : commands.toCharArray()) {
            Direction direction = currentDirection(currentPosition);
            if (c == 'R') {
                currentPosition = turnRight(currentPosition,direction);
            } else {
                currentPosition = turnLeft(currentPosition,direction);
            }
        }
        return  currentPosition;
    }


    private Direction currentDirection(String initialPosition) {
        char initialDirection = initialPosition.charAt(initialPosition.length() -1);
        if (initialDirection == 'N') return Direction.NORTH;
        else if (initialDirection == 'E') return Direction.EAST;
        else if (initialDirection == 'S') return Direction.SOUTH;
        else return Direction.WEST;
    }

    enum Direction{
        NORTH('W','N','E'),
        EAST('N','E','S'),
        SOUTH('E','S','W'),
        WEST('S','W','N');

        private final char left;
        private final char value;
        private final char right;
        Direction(char left, char value, char right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
    }

    private String turnRight(String currentPosition, Direction currentDirection){
        return currentPosition.replace(currentDirection.value, currentDirection.right);
    }
    private String turnLeft(String currentPosition, Direction currentDirection) {
        return currentPosition.replace(currentDirection.value, currentDirection.left);
    }
}

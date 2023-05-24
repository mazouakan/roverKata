package org.example.model;

public enum Direction{
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

    public char getLeft() {
        return left;
    }

    public char getValue() {
        return value;
    }

    public char getRight() {
        return right;
    }



}

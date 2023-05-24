package org.example.data;

import java.util.List;

public class InputData {
    private int width;
    private int height;

    private List<RoverData> roversSquad;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<RoverData> getRoversSquad() {
        return roversSquad;
    }

    public void setRoversSquad(List<RoverData> roversSquad) {
        this.roversSquad = roversSquad;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "width=" + width +
                ", height=" + height +
                ", roversSquad=" + roversSquad +
                '}';
    }
}

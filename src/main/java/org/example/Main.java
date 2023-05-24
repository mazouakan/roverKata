package org.example;

import org.example.data.InputData;
import org.example.data.RoverData;
import org.example.model.Grid;
import org.example.model.Rover;
import org.example.parser.Parser;
import org.example.parser.ParserImpl;

import java.io.*;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        String inputFileName = args[0];
        Parser parser = new ParserImpl();
        InputData inputData = parser.parseFile(inputFileName);
        //System.out.println(inputData.toString());
        Grid grid = new Grid(inputData.getWidth(), inputData.getHeight());
        for(RoverData roverData : inputData.getRoversSquad()){
            Rover rover = new Rover(grid);
            String finalPosition = rover.explore(roverData.getInitialposition(), roverData.getCommandes());
            System.out.println(finalPosition);
            //grid.updateDeployedRovers(rover.coordinate);
        }




    }


}
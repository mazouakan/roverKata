package org.example.parser;

import org.example.data.InputData;
import org.example.Main;
import org.example.data.RoverData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements  Parser{
    @Override
    public InputData parseFile(String inputFileName) throws IOException {

        InputData inputData = new InputData();

        File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile());
        String path = file.getParent() + File.separator + inputFileName;

        FileReader fr = new FileReader(path);

        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        int i = 0;
        List<RoverData> roversData = new ArrayList<>();

        while(line != null){

            if(i==0){
                String[] dimensions = line.split(" ");
                inputData.setWidth(Integer.parseInt(dimensions[0]));
                inputData.setHeight(Integer.parseInt(dimensions[1]));
                i++;

            }
            else {

                String initialPosition = line;
                line = br.readLine();
                String commandes = line;
                RoverData roverData = new RoverData(initialPosition, commandes);
                roversData.add(roverData);

            }
            line = br.readLine();

        }
            inputData.setRoversSquad(roversData);

        return inputData;
    }
}

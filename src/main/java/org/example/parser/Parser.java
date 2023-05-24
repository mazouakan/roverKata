package org.example.parser;

import org.example.data.InputData;

import java.io.IOException;

public interface Parser {

    InputData parseFile(String fileName) throws IOException;
}

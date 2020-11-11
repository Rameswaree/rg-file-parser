package com.parser.file.service;

import com.parser.file.parsers.TextFileParser;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileParserServiceImpl {

    private static final String ORIGINAL_PATH = "src/main/resources/unprocessed";
    private static final String NEW_PATH = "src/main/resources/processed";

    TextFileParser textFileParser = new TextFileParser();
    public boolean getFileParsed(){

        boolean fileParsed = true;

        try{
                Object[] filesList = Files.list(Paths.get(ORIGINAL_PATH)).toArray();

                for(Object file:filesList){
                    String name = textFileParser.processedFileName(String.valueOf(file));

                    System.out.println();

                    if(name.isEmpty()){
                        return false;
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileParsed;
    }
}

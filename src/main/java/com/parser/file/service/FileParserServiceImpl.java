package com.parser.file.service;

import com.parser.file.parsers.TextFileParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParserServiceImpl {

    private static final String PATH = "src/main/resources/unprocessed";

    TextFileParser textFileParser = new TextFileParser();
    public boolean getFileParsed(){

        boolean fileParsed = true;

        try{
                File[] filesList = (File[]) Files.list(Paths.get(PATH)).toArray();

                for(File file:filesList){
                    String name = textFileParser.processedFileName(String.valueOf(file));
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

package com.parser.file;

import com.parser.file.service.FileParserServiceImpl;

public class FileParserApplication {

    public static void main(String[] args){
        FileParserServiceImpl fileParserService = new FileParserServiceImpl();
        boolean isFileParsed = fileParserService.getFileParsed();

        if(isFileParsed){
            System.out.println("File has been successfully parsed");
        }
    }
}

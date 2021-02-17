package com.parser.file.parsers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TextFileParser {

    public String processedFileName(String fileName){

        System.out.println("Number of words in " + fileName + ": " + numberOfWords(fileName));
        System.out.println("Number of dots in " + fileName + ": " + numberOfDots(fileName));
        System.out.println("Most used words in " + fileName + ": " + mostUsedWords(fileName));

        return fileName;
    }

    public String mostUsedWords(String fileName) {
        Path path = Paths.get(fileName);
        Stream<String> fileLines = null;
        try {
            fileLines = Files.lines(path, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Integer> hashMap = new HashMap<>();

        if(fileLines != null){
            Object[] words = fileLines.flatMap(line -> Arrays.stream(line.split(" "))).toArray();

            for(Object word:words){
                hashMap.put((String) word, hashMap.getOrDefault(word, 0) + 1);
            }
        }


        return Collections.max(hashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int numberOfDots(String fileName) {

        int dotCount = 0;
        Path path = Paths.get(fileName);
        Stream<String> fileLines = null;
        try {
            fileLines = Files.lines(path, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fileLines !=null)
            dotCount = (int) fileLines.flatMap(line -> Arrays.stream(new String[]{line.replaceAll("[.]+", "")})).count();


        return dotCount;
    }

    public int numberOfWords(String fileName) {

        int wordCount = 0;
        Path path = Paths.get(fileName);
        Stream<String> fileLines = null;
        try {
            fileLines = Files.lines(path, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fileLines !=null)
           wordCount = (int) fileLines.flatMap(line -> Arrays.stream(line.split(" "))).count();

        return wordCount;
    }
}

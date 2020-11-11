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

        System.out.println("Number of words: " + numberOfWords(fileName));
        System.out.println("Number of dots: " + numberOfDots(fileName));
        System.out.println("Most used words: " + mostUsedWords(fileName));

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
            String[] words = (String[]) fileLines.flatMap(line -> Arrays.stream(line.split(" "))).toArray();

            for(String word:words){
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            }
        }


        return Collections.max(hashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int numberOfDots(String fileName) {

        int totalWords = numberOfWords(fileName);
        int wordsWithoutDots = 0;
        Path path = Paths.get(fileName);
        Stream<String> fileLines = null;
        try {
            fileLines = Files.lines(path, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fileLines !=null)
            wordsWithoutDots = (int) fileLines.flatMap(line -> Arrays.stream(new String[]{line.replaceAll("[.]", "")})).count();


        return totalWords - wordsWithoutDots;
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

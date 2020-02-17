package com.bilichenko.test.composite_words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {

   private static String FILE = "words.txt";
   private static String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException {
        initParams(args);

        List<String> words = readWords();

        CompositeWords compositeWords = new CompositeWords(words);

        String longestCompositeWord = compositeWords.getNLongestCompositeWord(1);
        String secondLongest = compositeWords.getNLongestCompositeWord(2);
        int countOfConcatenatedWords = compositeWords.getCountConcatenatedWords();

        StringBuilder output = new StringBuilder();
        output.append("the longest concatenated word is:")
                .append(System.lineSeparator())
                .append(longestCompositeWord)
                .append(System.lineSeparator())
                .append("the second longest word is:")
                .append(System.lineSeparator())
                .append(secondLongest)
                .append(System.lineSeparator())
                .append("total concatenated words count:")
                .append(System.lineSeparator())
                .append(countOfConcatenatedWords);

        Files.write(Paths.get(OUTPUT), Collections.singletonList(output.toString()), UTF_8, CREATE);
    }

    private static List<String> readWords() throws IOException {
        return Files.readAllLines(Paths.get(FILE), UTF_8).stream()
                .flatMap(l -> Arrays.stream(l.split("\\s")))
                .collect(Collectors.toList());
    }

    private static void initParams(String[] args) {
        if (args.length > 0) {
            FILE = args[0];
            if (args.length > 1) {
                OUTPUT = args[1];
            }
        }
    }
}

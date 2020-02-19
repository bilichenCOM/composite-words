package com.bilichenko.test.composite_words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {

    private static final String DEFAULT_INPUT = "test.txt";
    private static final String DEFAULT_OUTPUT = "output.txt";

    private static String input;
    private static String output;

    public static void main(String[] args) throws IOException {
        initParams(args);

        List<String> words = readWords();
        Collections.sort(words, Comparator.comparing(String::length));

        long start = System.currentTimeMillis();
        List<String> compositeWords = CompositeWords.retrieveCompositeWords(words);
        long elapsed = (System.currentTimeMillis() - start) / 1000;
        final String timeTaken = String.format("retrieving composite words took %d seconds", elapsed);
        System.out.println(timeTaken);

        int firstIndex = compositeWords.size() - 1;
        String longestCompositeWord = compositeWords.get(firstIndex);
        int secondIndex = compositeWords.size() - 2;
        String secondLongest = compositeWords.get(secondIndex);
        int countOfConcatenatedWords = compositeWords.size();

        StringBuilder output = new StringBuilder();
        output.append("the longest concatenated word is:")
                .append(lineSeparator())
                .append(longestCompositeWord)
                .append(lineSeparator())
                .append("the second longest word is:")
                .append(lineSeparator())
                .append(secondLongest)
                .append(lineSeparator())
                .append("total concatenated words count:")
                .append(lineSeparator())
                .append(countOfConcatenatedWords)
                .append(lineSeparator())
                .append(timeTaken);

        Files.write(Paths.get(Main.output), Collections.singletonList(output.toString()), UTF_8, CREATE);
    }

    private static List<String> readWords() throws IOException {
        return Files.readAllLines(Paths.get(input), UTF_8).stream()
                .flatMap(l -> Arrays.stream(l.split("\\s")))
                .collect(Collectors.toList());
    }

    private static void initParams(String[] args) {
        if (args.length > 0) {
            input = args[0];
            if (args.length > 1) {
                output = args[1];
            } else {
                output = DEFAULT_OUTPUT;
            }
        } else {
            input = DEFAULT_INPUT;
            output = DEFAULT_OUTPUT;
        }
    }
}

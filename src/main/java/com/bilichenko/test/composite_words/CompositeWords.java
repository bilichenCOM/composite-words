package com.bilichenko.test.composite_words;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompositeWords {

    // this method return only those words,
    // which are concatenation of other words
    // in input list
    public static List<String> retrieveCompositeWords(List<String> sortedWords) {
        List<String> compositeWords = new ArrayList<>();
        List<String> strongWords = new ArrayList<>();
        for (int i = 0; i < sortedWords.size(); i++) {
            String word = sortedWords.get(i);
            String temp = word;
            System.out.println(i + " " + word);
            for (String strong:strongWords) {
                temp = temp.replaceAll(strong, "");
            }
            if (temp.isEmpty()) {
                compositeWords.add(word);
            } else {
                strongWords.add(temp);
                strongWords.sort(Comparator.comparing(String::length).reversed());
            }
        }
        return compositeWords;
    }
}

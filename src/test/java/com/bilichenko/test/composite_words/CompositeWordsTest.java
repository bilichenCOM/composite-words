package com.bilichenko.test.composite_words;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeWordsTest {

    private static final List<String> TEST_WORDS;

    static {
        TEST_WORDS = asList("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat");
    }

    @BeforeAll
    static void sortList() {
        Collections.sort(TEST_WORDS, Comparator.comparing(String::length));
    }

    @Test
    void retrieveCompositeWords() {
        List<String> expected = asList("dogcatsdog", "catsdogcats", "ratcatdogcat");

        List<String> actual = CompositeWords.retrieveCompositeWords(TEST_WORDS);

        assertEquals(expected, actual);
    }
}

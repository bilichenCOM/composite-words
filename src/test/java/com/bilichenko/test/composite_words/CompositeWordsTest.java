package com.bilichenko.test.composite_words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeWordsTest {

    private static final List<String> TEST_WORDS = asList("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat");

    private static CompositeWords compositeWords;

    @BeforeEach
    void initTestObject() {
        compositeWords = new CompositeWords(TEST_WORDS);
    }

    @Test
    void getNLongestCompositeWord() {
        assertEquals("ratcatdogcat", compositeWords.getNLongestCompositeWord(1));
        assertEquals("catsdogcats", compositeWords.getNLongestCompositeWord(2));
    }

    @Test
    void getCountConcatenatedWords() {
        assertEquals(3, compositeWords.getCountConcatenatedWords());
    }

    @Test
    void removeComposite() {
        //TODO: implement tests for this method;
    }
}
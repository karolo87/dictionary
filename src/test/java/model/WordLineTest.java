package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class WordLineTest {

    private WordLine wordLine;

    @BeforeEach
    public void setUp() {
        Set<Word> wordSet = new TreeSet<>();
        wordSet.add(new Word("pencil", Language.ENGLISH));
        wordSet.add(new Word("crayon", Language.FRENCH));
        wordSet.add(new Word("ołówek", Language.POLISH));

        this.wordLine = new WordLine(wordSet);

    }

    @Test
    void sortByLanguage() {
        Set<Word> wordSet = new TreeSet<>();
        wordSet.add(new Word("crayon", Language.FRENCH));
        wordSet.add(new Word("ołówek", Language.POLISH));
        wordSet.add(new Word("pencil", Language.ENGLISH));
        WordLine wordLine = new WordLine(wordSet);

        assertEquals(this.wordLine, wordLine);
    }

//    private WordLine wordLine;
//
//    @BeforeEach
//    public void setUp() {
//        wordLine.getWordLine().add(new Word("pies", Language.POLISH));
//        wordLine.getWordLine().add(new Word("dog", Language.ENGLISH));
//        wordLine.getWordLine().add(new Word("chien", Language.FRENCH));
//    }
//
//    @Test
//    private void assertTrueIfWordLineIsSortedByLanguage() {
//
//        assertTrue(wordLine.sortByLanguage());
//    }
}
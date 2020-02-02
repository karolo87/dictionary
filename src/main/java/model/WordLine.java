package model;

import java.util.Set;

public class WordLine {

    private Set<Word> wordLine;

    public WordLine(Set<Word> wordLine) {
        this.wordLine = wordLine;
    }

    public Set<Word> getWordLine() {
        return wordLine;
    }

    public void setWordLine(Set<Word> wordLine) {
        this.wordLine = wordLine;
    }

    @Override
    public String toString() {
        return "WordLine{" +
                "wordLine=" + wordLine +
                '}';
    }
}

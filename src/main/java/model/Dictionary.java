package model;

import java.util.List;

public class Dictionary {

    private List<WordLine> wordList;

    public Dictionary(List<WordLine> wordList) {
        this.wordList = wordList;
    }

    public List<WordLine> getWordList() {
        return wordList;
    }

    public void setWordList(List<WordLine> wordList) {
        this.wordList = wordList;
    }
}

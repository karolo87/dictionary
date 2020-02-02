package model;

import java.util.Objects;

public class Word {

    private String word;
    private Language language;

    public Word(String word, Language language) {
        this.word = word;
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word) &&
                language == word1.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, language);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", language=" + language +
                '}';
    }
}

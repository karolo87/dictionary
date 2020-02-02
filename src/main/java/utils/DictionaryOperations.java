package utils;

import model.Dictionary;
import model.Word;
import model.WordLine;

import java.util.HashSet;
import java.util.Set;

public class DictionaryOperations {

    private Dictionary dictionary;

    public DictionaryOperations(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean addWordToDictionary(Word word) {

        if (AddingWordValidation.checkIfWordExists(this.dictionary, word)) {
            System.out.println("Word already exists in a dictionary.");
            return false;
        }
        Set<Word> words = new HashSet<>();
        words.add(word);
        WordLine wordLine = new WordLine(words);
        this.dictionary.getWordList().add(wordLine);
        System.out.println(word.getWord() + " successfully added!");
        return true;
    }

    public boolean addWordWithTranslation(Word word1, Word word2) {
        if (word1.getLanguage() == null || word2.getLanguage() == null) return false;
        if (AddingWordValidation.checkIfWordExists(this.dictionary, word1)
                && AddingWordValidation.checkIfWordExists(this.dictionary, word2)) {
            System.out.println(word1 + " - " + word2 + " -> this line already exists!");
            return false;
        }
        if (!AddingWordValidation.checkIfWordExists(this.dictionary, word1)
                && !AddingWordValidation.checkIfWordExists(this.dictionary, word2)) {
            Set<Word> wordSet = new HashSet<>();
            wordSet.add(word1);
            wordSet.add(word2);
            this.dictionary.getWordList().add(new WordLine(wordSet));
            return true;
        }
        this.dictionary.getWordList().forEach(wordLine -> {
            if (wordLine.getWordLine().contains(word1)) wordLine.getWordLine().add(word2);
            if (wordLine.getWordLine().contains(word2)) wordLine.getWordLine().add(word1);
        });
        return true;
    }

}

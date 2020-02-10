package utils;

import model.Dictionary;
import model.Language;
import model.Word;
import model.WordLine;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Set<Word> words = new TreeSet<>(Comparator.comparing(Word::getLanguage));
        words.add(word);
        WordLine wordLine = new WordLine(words);
//        wordLine.sortByLanguage();
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

        List<WordLine> wordList = this.dictionary.getWordList();
        if (!AddingWordValidation.checkIfWordExists(this.dictionary, word1)
                && !AddingWordValidation.checkIfWordExists(this.dictionary, word2)) {
            Set<Word> wordSet = new TreeSet<>(Comparator.comparing(Word::getLanguage));
            wordSet.add(word1);
            wordSet.add(word2);
            WordLine wordLine = new WordLine(wordSet);
            wordList.add(wordLine);
            return true;
        }
        wordList.forEach(wordLine -> {
            if (wordLine.getWordLine().contains(word1)) wordLine.getWordLine().add(word2);
            if (wordLine.getWordLine().contains(word2)) wordLine.getWordLine().add(word1);
        });
        return true;
    }

    public List<Set<Word>> displayDictionarySorted(Dictionary dictionary) {
        return dictionary.getWordList().stream()
                .map(WordLine::getWordLine)
                .sorted(Comparator.comparing(Object::toString))
                .collect(Collectors.toList());
    }

}

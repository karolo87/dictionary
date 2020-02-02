package utils;

import model.Dictionary;
import model.Word;
import model.WordLine;

public class AddingWordValidation {

    public static boolean checkIfWordExists(Dictionary dictionary, Word word) {
        return dictionary.getWordList().stream()
                .map(WordLine::getWordLine)
                .anyMatch(words -> words.contains(word));
    }
}

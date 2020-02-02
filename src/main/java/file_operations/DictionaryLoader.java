package file_operations;

import model.Dictionary;
import model.Language;
import model.Word;
import model.WordLine;
import utils.LanguageParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DictionaryLoader {

    public static Dictionary loadDictionaryFromFile(String fileName) {
        List<WordLine> wordList = new ArrayList<>();
        Dictionary dictionary = new Dictionary(wordList);

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                wordList.add(parseStringToWordLine(line));
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    private static WordLine parseStringToWordLine(String line) {
        String[] split = line.split(";");

        Set<Word> words = new HashSet<>();
        WordLine wordLine = new WordLine(words);

        for (int i = 0; i < split.length; i += 2) {
            String word = split[i];
            Language language = LanguageParser.parseStringToLanguage(split[i + 1]);
            words.add(new Word(word, language));
        }
        return wordLine;
    }
}

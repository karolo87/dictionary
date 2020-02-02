import file_operations.DictionarySaver;
import model.Dictionary;
import model.Language;
import model.Word;
import model.WordLine;
import utils.DictionaryOperations;
import utils.LanguageParser;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<WordLine> wordList = new ArrayList<>();

        Dictionary dictionary = new Dictionary(wordList);
        DictionaryOperations dictionaryOperations = new DictionaryOperations(dictionary);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your option: (1 - enter pair of words, 2 - enter a single word, 3 - display a dictionary)");
        String option = scanner.next();
        dictionary.getWordList().forEach(System.out::println);

        do {
            switch (option) {

                case "1":
                    System.out.println("Enter language: ('PL' / 'ENG' / 'FR')");
                    String lang1 = scanner.next();
                    System.out.println("Enter word in given language:");
                    String word1 = scanner.next();
                    Word wordA = new Word(word1, LanguageParser.parseStringToLanguage(lang1));

                    System.out.println("Enter language: ('PL' / 'ENG' / 'FR')");
                    String lang2 = scanner.next();
                    System.out.println("Enter word in given language:");
                    String word2 = scanner.next();
                    Word wordB = new Word(word2, LanguageParser.parseStringToLanguage(lang2));
                    dictionaryOperations.addWordWithTranslation(wordA, wordB);
                    break;
                case "2":
                    System.out.println("Enter language: ('PL' / 'ENG' / 'FR')");
                    String lang = scanner.next();
                    System.out.println("Enter word in given language:");
                    String word = scanner.next();
                    dictionaryOperations.addWordToDictionary(new Word(word, LanguageParser.parseStringToLanguage(lang)));
                    break;
                case "3":
                    dictionary.getWordList().forEach(System.out::println);
            }
            System.out.println("Choose your option: (1 - enter pair of words, 2 - enter a single word, 3 - display a dictionary)");
            option = scanner.next();
        } while (!option.equalsIgnoreCase("quit"));

        DictionarySaver.saveDictionaryToFile(dictionary);
    }
}

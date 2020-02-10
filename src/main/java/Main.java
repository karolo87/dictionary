import file_operations.DictionaryLoader;
import file_operations.DictionarySaver;
import model.Dictionary;
import model.Word;
import utils.DictionaryOperations;
import utils.LanguageParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Dictionary dictionary = DictionaryLoader.loadDictionaryFromFile("src/main/resources/dictionary.txt");
        DictionaryOperations dictionaryOperations = new DictionaryOperations(dictionary);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your option: (1 - enter pair of words, 2 - enter a single word, 3 - display a dictionary)" +
                " 4 - display a dictionary sorted, with given languages)");
        String option = scanner.next();

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
                    break;
                case "4":
                    dictionaryOperations.displayDictionarySorted(dictionary).forEach(System.out::println);
//                    System.out.println("Enter 1st language: ('PL' / 'ENG' / 'FR')");
//                    Language lang_1 = LanguageParser.parseStringToLanguage(scanner.next());
//                    System.out.println("Enter 2nd language: ('PL' / 'ENG' / 'FR')");
//                    Language lang_2 = LanguageParser.parseStringToLanguage(scanner.next());
//                    dictionaryOperations.displayDictionarySorted(dictionary, lang_1, lang_2);
//                    break;
            }
            System.out.println("Choose your option: (1 - enter pair of words, 2 - enter a single word, 3 - display a dictionary," +
                    " 4 - display a dictionary sorted, with given languages)");
            option = scanner.next();
        } while (!option.equalsIgnoreCase("quit"));

        DictionarySaver.saveDictionaryToFile(dictionary);
    }
}

package file_operations;

import model.Dictionary;
import model.Word;
import model.WordLine;

import java.io.*;
import java.util.List;
import java.util.Set;

public class DictionarySaver {

    public static void saveDictionaryToFile(Dictionary dictionary) {

        try (FileWriter fileWriter = new FileWriter("src/main/resources/dictionary.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)){
            List<WordLine> wordLineList = dictionary.getWordList();
            for (WordLine wordLine : wordLineList) {
                printWriter.write(parseWordlineToString(wordLine) + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseWordlineToString(WordLine wordLine) {
        StringBuilder sb = new StringBuilder();
        wordLine.getWordLine().forEach(word -> sb.append(word.getWord()).append(";").append(word.getLanguage()).append(";"));
        sb.deleteCharAt(sb.length() - 1);
        return new String(sb);
    }
}

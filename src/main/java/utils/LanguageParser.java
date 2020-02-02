package utils;

import model.Language;

public class LanguageParser {

    public static Language parseStringToLanguage(String languageString) {
        if (languageString.toUpperCase().contains("POLISH") || languageString.toUpperCase().contains("PL")) return Language.POLISH;
        if (languageString.toUpperCase().contains("ENG") || languageString.toUpperCase().contains("ENGLISH")) return Language.ENGLISH;
        if (languageString.toUpperCase().contains("FR") || languageString.toUpperCase().contains("FRENCH")) return Language.FRENCH;
        else throw new IllegalArgumentException("Unfortunately our dictionary does not support given language.");
    }
}

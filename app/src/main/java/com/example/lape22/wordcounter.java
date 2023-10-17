package com.example.lape22;

public class wordcounter{
    public static int getWordCount(String phrase) {
        // Split the phrase by spaces and count the resulting array length
        String[] words = phrase.trim().split("\\s+");
        return words.length;

}
}


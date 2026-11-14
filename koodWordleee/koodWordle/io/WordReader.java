package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader {
    private static final String WORD_FILE = "wordle-words.txt";

    public List<String> readWords() {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(WORD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 5) {
                    words.add(line.trim().toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading word list file: " + e.getMessage());
            return null;
        }
        return words;
    }
}
package game;

import io.WordReader;
import io.StatsManager;
import model.GameResult;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GameEngine {
    private static final int MAX_ATTEMPTS = 6;
    private static final int WORD_LENGTH = 5;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_RESET = "\u001B[0m";

    private Scanner scanner;
    private WordReader wordReader;
    private StatsManager statsManager;
    private String secretWord;
    private List<String> wordList;

    public GameEngine(Scanner scanner) {
        this.scanner = scanner;
        this.wordReader = new WordReader();
        this.statsManager = new StatsManager();
    }

    public void startGame(int wordIndex) {
        wordList = wordReader.readWords();
        if (wordList == null || wordIndex < 0 || wordIndex >= wordList.size()) {
            System.out.println("Invalid word index or word list unavailable.");
            return;
        }

        secretWord = wordList.get(wordIndex).toUpperCase();
        playGame();
    }

    private void playGame() {
        int attempts = 0;
        boolean won = false;
        Set<Character> remainingLetters = initializeRemainingLetters();
        String username = "";

        System.out.println("Enter your username:");
        username = scanner.nextLine().trim();

        while (attempts < MAX_ATTEMPTS && !won) {
            System.out.println("Enter your guess:");
            String guess = scanner.nextLine().trim();

            if (guess.length() != WORD_LENGTH) {
                System.out.println("Your guess must be exactly 5 letters long");
                continue;
            }

            if (!guess.matches("[a-z]+")) {
                System.out.println("Your guess must only contain lowercase letters");
                continue;
            }

            if (!wordList.contains(guess)) {
                System.out.println("Word not in list. Please enter a valid word.");
                continue;
            }

            String guessUpper = guess.toUpperCase();
            attempts++;
            Feedback feedback = generateFeedback(guessUpper);
            updateRemainingLetters(remainingLetters, guessUpper, feedback);

            displayFeedback(feedback, guessUpper);
            displayRemainingLetters(remainingLetters);

            if (guessUpper.equals(secretWord)) {
                won = true;
                System.out.println("Congratulations! You've guessed the word correctly.");
            } else if (attempts == MAX_ATTEMPTS) {
                System.out.println("Game over. The correct word was: " + secretWord.toLowerCase());
            }
        }

        statsManager.saveGameResult(new GameResult(username, secretWord.toLowerCase(), attempts, won ? "win" : "loss"));

        promptForStats(username);
    }

    private Feedback generateFeedback(String guess) {
        char[] feedback = new char[WORD_LENGTH];
        Map<Character, Integer> letterCounts = new HashMap<>();

        for (char c : secretWord.toCharArray()) {
            letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            if (guess.charAt(i) == secretWord.charAt(i)) {
                feedback[i] = 'G';
                letterCounts.put(guess.charAt(i), letterCounts.get(guess.charAt(i)) - 1);
            }
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            if (feedback[i] != 'G') {
                char guessChar = guess.charAt(i);
                if (letterCounts.getOrDefault(guessChar, 0) > 0) {
                    feedback[i] = 'Y';
                    letterCounts.put(guessChar, letterCounts.get(guessChar) - 1);
                } else {
                    feedback[i] = 'W';
                }
            }
        }

        return new Feedback(feedback);
    }

    private Set<Character> initializeRemainingLetters() {
        Set<Character> letters = new HashSet<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            letters.add(c);
        }
        return letters;
    }

    private void updateRemainingLetters(Set<Character> remainingLetters, String guess, Feedback feedback) {
        for (int i = 0; i < guess.length(); i++) {
            if (feedback.getFeedback()[i] == 'W') {
                remainingLetters.remove(guess.charAt(i));
            }
        }
    }

    private void displayFeedback(Feedback feedback, String guess) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < WORD_LENGTH; i++) {
            char status = feedback.getFeedback()[i];
            String color = status == 'G' ? ANSI_GREEN : status == 'Y' ? ANSI_YELLOW : ANSI_WHITE;
            output.append(color).append(guess.charAt(i)).append(ANSI_RESET);
        }
        System.out.println(output.toString());
    }

    private void displayRemainingLetters(Set<Character> remainingLetters) {
        System.out.print("Remaining letters: ");
        StringBuilder lettersStr = new StringBuilder();
        for (char c = 'A'; c <= 'Z'; c++) {
            if (remainingLetters.contains(c)) {
                lettersStr.append(c).append(" ");
            }
        }
        System.out.println(lettersStr.toString().trim());
    }

    private void promptForStats(String username) {
        System.out.println("Do you want to see your stats? (yes/no):");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes")) {
            statsManager.displayStats(username);
            System.out.println("Press Enter to exit...");
            scanner.nextLine();
        }
    }
}
package model;

public class GameResult {
    private String username;
    private String secretWord;
    private int attempts;
    private String outcome;

    public GameResult(String username, String secretWord, int attempts, String outcome) {
        this.username = username;
        this.secretWord = secretWord;
        this.attempts = attempts;
        this.outcome = outcome;
    }

    public String getUsername() {
        return username;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getOutcome() {
        return outcome;
    }
}
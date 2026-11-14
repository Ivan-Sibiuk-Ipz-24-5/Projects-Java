package io;

import model.GameResult;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatsManager {
    private static final String STATS_FILE = "stats.csv";

    public void saveGameResult(GameResult result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STATS_FILE, true))) {
            String line = String.format("%s,%s,%d,%s",
                    result.getUsername(),
                    result.getSecretWord(),
                    result.getAttempts(),
                    result.getOutcome());
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving game stats: " + e.getMessage());
        }
    }

    public void displayStats(String username) {
        List<GameResult> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(STATS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(username)) {
                    results.add(new GameResult(
                            parts[0],
                            parts[1],
                            Integer.parseInt(parts[2]),
                            parts[3]
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading stats: " + e.getMessage());
            return;
        }

        if (results.isEmpty()) {
            System.out.println("No stats available.");
            return;
        }

        int totalGames = results.size();
        int totalAttempts = 0;
        int wins = 0;

        System.out.println("Stats for " + username + ":");
        for (GameResult result : results) {
            System.out.printf("Word: %s, Attempts: %d, Outcome: %s%n",
                    result.getSecretWord(),
                    result.getAttempts(),
                    result.getOutcome());
            totalAttempts += result.getAttempts();
            if (result.getOutcome().equals("win")) {
                wins++;
            }
        }

        System.out.printf("Games played: %d%n", totalGames);
        System.out.printf("Games won: %d%n", wins);
        double averageAttempts = totalGames > 0 ? (double) totalAttempts / totalGames : 0;
        System.out.printf("Average attempts per game: %.2f%n", averageAttempts);
    }
}
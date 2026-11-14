import game.GameEngine;
import java.util.Scanner;

public class WordleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine gameEngine = new GameEngine(scanner);

        try {
            int wordIndex = Integer.parseInt(args[0]);
            gameEngine.startGame(wordIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide a number as command line argument");
            System.out.println("Press Enter to exit...");
            scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Invalid command-line argument. Please launch with a valid number");
            System.out.println("Press Enter to exit...");
            scanner.nextLine();
        }

        scanner.close();
    }
}
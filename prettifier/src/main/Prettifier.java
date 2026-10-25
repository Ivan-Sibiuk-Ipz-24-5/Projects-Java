package main;

import tools.*;
import java.io.*;
import java.util.*;

public class Prettifier {
    public static void main(String[] args) {
        // usage -h
        if (args.length == 1 && args[0].equals("-h")) {
            printUsage();
            return;
        }

        if (args.length < 3) {
            printUsage();
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];
        String csvPath = args[2];

        File inputFile = new File(inputPath);
        File csvFile = new File(csvPath);

        if (!inputFile.exists()) {
            System.out.println("Input not found");
            return;
        }

        if (!csvFile.exists()) {
            System.out.println("Airport lookup not found");
            return;
        }

        try {
            AirportLookup lookup = new AirportLookup(csvPath);
            List<String> routes = TextProcessor.readLines(inputPath);
            List<String> formatted = tools.Formatter.formatRoutes(routes, lookup);
            TextProcessor.writeLines(outputPath, formatted);
            System.out.println("✅ Done! Results saved to " + outputPath);
        } catch (IllegalArgumentException e) {
            System.out.println("Airport lookup malformed");
        } catch (IOException e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    // instructions 
    private static void printUsage() {
        System.out.println("itinerary usage:");
        System.out.println("java -cp out main.Prettifier <input.txt> <output.txt> <airport-lookup.csv>");
    }
}

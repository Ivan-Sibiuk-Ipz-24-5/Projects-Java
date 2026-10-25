package tools;

import java.io.*;
import java.util.*;

public class TextProcessor {

    public static List<String> readLines(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("\f", "\n").replace("\r", "\n").replace("\u000B", "\n");

                lines.add(line);
            }
        }
        return lines;
    }

    public static void writeLines(String path, List<String> lines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    public static List<String> trimEmptyLines(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean lastEmpty = false;
        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                if (!lastEmpty) result.add("");
                lastEmpty = true;
            } else {
                result.add(trimmed);
                lastEmpty = false;
            }
        }
        return result;
    }
}

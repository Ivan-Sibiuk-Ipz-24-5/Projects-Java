package com.bestCypher.cyphers;

import java.util.Scanner;

public class CustomCipher implements Cipher {
    private Scanner scanner = new Scanner(System.in);
    public String encrypt(String data) {
        System.out.println("На скільки бажаєте змістити?");
        int stepText = scanner.nextInt();
        return rot(data, stepText); 
    }
    //для дешифрування використав віднімання
    public String decrypt(String data) {
        System.out.println("На скільки бажаєте змістити?");
        int stepText = scanner.nextInt();
        return rot(data, -stepText); 
    }
    private String rot(String inputText, int stepNumber) {
        StringBuilder result = new StringBuilder();

        for (char c : inputText.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char stepNumber1 = (char) ('A' + (c - 'A' + stepNumber + 26) % 26);
                result.append(stepNumber1);
            } else if (Character.isLowerCase(c)) {
                char stepNumber1 = (char) ('a' + (c - 'a' + stepNumber + 26) % 26);
                result.append(stepNumber1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
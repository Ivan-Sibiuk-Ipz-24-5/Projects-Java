package com.bestCypher.cyphers;

public class AtbashCipher implements Cipher {
    public String encrypt(String data) {
        return Atbash(data);
    } // пока-що порожні методи -- шифр

    public String decrypt(String data) {
        return Atbash(data);
    } //розшифрування

    private String Atbash(String input) { //  майбутній шифр
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 'a' && c <= 'z') {
                result.append((char) ('z' - (c - 'a')));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) ('Z' - (c - 'A')));
            }
            else {
                result.append(c);
            }
        }
        return  result.toString();
    }
}

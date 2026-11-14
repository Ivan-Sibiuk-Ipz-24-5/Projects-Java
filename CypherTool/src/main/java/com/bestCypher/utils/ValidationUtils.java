package com.bestCypher.utils;

public class ValidationUtils {

    public String TestValidationUserInput(String userInput)
    {
        StringBuilder newString = new StringBuilder();
        for(int i=0;i<userInput.length();i++)
         {
          if(Character.isLetter(userInput.charAt(i)) || Character.isDigit(userInput.charAt(i)))
          {
            newString.append(userInput.charAt(i));
          }
         }
        return newString.toString().toLowerCase();
        
    }
    // ось перевірка на те , чи буква , якщо буква то true можна шифрувати якщо ні то false і залишається як є
    public Boolean TestValidationUserCode(char userInput)
    {
       if(Character.isLetter(userInput))
       {
        return true;
       }
       return false;
    }
}
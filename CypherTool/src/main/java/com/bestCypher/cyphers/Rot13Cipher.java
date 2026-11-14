package com.bestCypher.cyphers;

import com.bestCypher.utils.ValidationUtils;

public class Rot13Cipher implements Cipher {

 public String encrypt(String data)
  {
   return Rot13Cipher(data);
  }

 public String decrypt(String data)
  {
    return Rot13Cipher(data);
  }

  public String Rot13Cipher(String data)
  {
    ValidationUtils Validation = new ValidationUtils();
    StringBuilder encryptCode = new StringBuilder();

    for(int i=0;i<data.length();i++)
     { 
       char symbol = data.charAt(i);
       if(!Validation.TestValidationUserCode(symbol))
       {
       encryptCode.append(symbol);
       }
       else if (Character.isUpperCase(symbol)) 
	      {
         symbol = (char) ((symbol - 65 + 13) % 26 + 65); 
         encryptCode.append(symbol);
        } 
	     else if (Character.isLowerCase(symbol)) 
	      {
         symbol = (char) ((symbol - 97 + 13) % 26 + 97);
         encryptCode.append(symbol);
        } 
        }
   return encryptCode.toString();
  }
}
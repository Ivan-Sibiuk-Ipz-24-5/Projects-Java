package com.bestCypher.cyphers;

public interface Cipher {
   public String encrypt(String data); 
   public String decrypt(String data); 
}
// це називаєтьcя інтерфес , я наче кажу що кожен наш шифратор має шифрувати  і дешиврувати інакше програма не запуститься 

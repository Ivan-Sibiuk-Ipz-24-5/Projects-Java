package com.bestCypher.model;

import java.util.Scanner;
import com.bestCypher.cyphers.AtbashCipher;
import com.bestCypher.cyphers.CustomCipher;
import com.bestCypher.cyphers.Rot13Cipher;
import com.bestCypher.utils.ValidationUtils;

public class InputData {

     Scanner scanner = new Scanner(System.in);
     ValidationUtils validation = new ValidationUtils();
     AtbashCipher atbashCipher = new AtbashCipher();
     CustomCipher customCipher = new CustomCipher();
     Rot13Cipher rot13Cipher = new Rot13Cipher();

    public void Menu() {
        System.out.println("Вiтаю в найкращому шифраторi i дешефраторi, колись саме вiн розшифрував 'Енiгму' (в рамках завдання данна програма не вміє розшифровувати 'Енігму') .");

        while (true) 
        {
            System.out.print("Введiть дiю \n1-Шифрувати \n2-Дешифрувати \nexit-вихiд з програми\n> ");
            String action = validation.TestValidationUserInput(scanner.nextLine());

            switch (action) 
            {
                case "exit":
                    System.out.println("Програма завершується...");
                    return;

                case "1":
                    encryptMenu();
                    break;

                case "2":
                    decryptMenu();
                    break;

                default:
                    System.out.println("Вибачте, не вдалось визначити що ви мали на увазi :( )");
                    break;
            }
        }
    }

    private void encryptMenu() {
        System.out.println("Оберіть шифратор \n1-AtbashCipher \n2-CaesarCipher \n3-Rot13Cipher \nexit-повернутись назад");
        String choice = validation.TestValidationUserInput(scanner.nextLine());
        if (choice.equals("exit")) return;
        System.out.print("Введiть текст для шифрування: ");
        String text = scanner.nextLine();
        switch (choice) 
        {
            case "1":
                System.out.println("Результат: " + atbashCipher.encrypt(text));
                break;
            case "2":
                System.out.println("Результат: " + customCipher.encrypt(text));
                break;
            case "3":
                System.out.println("Результат: " + rot13Cipher.encrypt(text));
                break;
            default:
                System.out.println("Невiдомий шифратор!");
                break;
        }
    }

    private void decryptMenu() 
    {
        System.out.println("Оберіть дешифратор \n1-AtbashCipher \n2-CaesarCipher \n3-Rot13Cipher \nexit-повернутись назад");
        String choice = validation.TestValidationUserInput(scanner.nextLine());
        if (choice.equals("exit")) 
        return;

        System.out.print("Введiть текст для дешифрування: ");
        String text = scanner.nextLine();

        switch (choice) 
        {
            case "1":
                System.out.println("Результат: " + atbashCipher.decrypt(text));
                break;
            case "2":
                System.out.println("Результат: " + customCipher.decrypt(text));
                break;
            case "3":
                System.out.println("Результат: " + rot13Cipher.decrypt(text));
                break;
            default:
                System.out.println("Невiдомий дешифратор!");
                break;
        }
    }
}

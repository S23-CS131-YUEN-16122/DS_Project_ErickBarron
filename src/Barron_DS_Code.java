/*
Erick Barron
CS 131
12-07-2023
Code will take text input and encode or decode using Caesar's Encryption method
*/

import java.util.Scanner;

public class Barron_DS_Code{
    //method to encrypt a letters
    public static char Encrypt(char letters){
        //shift uppercase letter by 3 using Caesar's encryption method
        if (Character.isUpperCase(letters)){
            return (char) ((letters - 'A' + 3) % 26 + 'A');
        }
        //shift lowercase by 3 using Caesar's encryption method
        else if (Character.isLowerCase(letters)){
            return (char) ((letters - 'a' + 3) % 26 + 'a');
        }
        //return if original message if input not letters
        else{
            return letters;
        }
    }
    //method to decrypt letters inverse of encrypt 26-3 = 23
    public static char Decrypt(char letters){
        //shift upercase letters by 23 ensures no negative int
        if (Character.isUpperCase(letters)){
            return (char) ((letters - 'A' + 23) % 26 + 'A');
        }
        //shift lowercase letters by 23
        else if (Character.isLowerCase(letters)){
            return (char) ((letters - 'a' + 23) % 26 + 'a');
        }
        else{
            return letters;
        }
    }
    //method to process message
    public static String processMessage(String message, boolean Encrypt) {
        //build MessageProcessor
        StringBuilder MessageProcessor = new StringBuilder();
        //iterate all letters in message
        for (char ch : message.toCharArray()) {
            //either encrypt, decrypt, or return original
            if (Encrypt) {
                MessageProcessor.append(Encrypt(ch));
            }
            else {
                MessageProcessor.append(Decrypt(ch));
            }
        }
        //convert ro string
        return MessageProcessor.toString();
    }

    public static void main(String[] args) {
        //scanner to read input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        System.out.print("Type encrypt or decrypt : ");
        String operation = scanner.nextLine().toLowerCase();

        //store result
        String resultMessage;

        //switch case to perform operation calling a specific process
        switch (operation) {
            case "encrypt":
                resultMessage = processMessage(message, true);
                System.out.println("Encrypted message: " + resultMessage);
                break;
            case "decrypt":
                resultMessage = processMessage(message, false);
                System.out.println("Decrypted message: " + resultMessage);
                break;
            default:
                System.out.println("Invalid operation. Please enter 'encrypt' or 'decrypt'.");
        }

        scanner.close();
    }
}
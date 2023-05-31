/**
 * Author: Nate Elison
 * Date: 5/30/23
 *
 * This program combines exercises 17-14 and 17-15. The program will either encrypt or decrypt a .txt or .dat file.
 * The user inputs the file name they want to encrypt or decrypt as well as the output file name. 
 * The file to be encrypted/decrypted must exist already. A test.txt file has been provided for testing.
 */

import java.io.*;
import java.util.Scanner;

public class Exercise17_14_15 {
    public static void main(String[] args) throws IOException {

        // Display menu and get selection from user.
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to encrypt or decrypt a file? \n\t" +
                "1) Encrypt\n\t" +
                "2) Decrypt");
        int selection = in.nextInt();

        // Run the encryption portion of the program
        if (selection == 1){
            String input = getFileName("Enter file name to be encrypted. Please include file type (.txt or .dat): ");
            String output = getFileName("Enter file name to be saved as the encrypted file. Please include file type (.txt or .dat): ");

            File sourceFile = new File(input);
            File outputFile = encryption(output, sourceFile);
            return;
        }

        // Run the decryption
        else if (selection == 2){
            String input = getFileName("Enter encrypted file name. Please include file type (.txt or .dat): ");
            String output = getFileName("Enter file name to be saved as the decrypted version. Please include file type (.txt or .dat): ");

            File sourceFile = new File(input);
            File outputFile = decryption(output, sourceFile);

        }
        else System.out.println("Selection invalid.");


    }

    // Method to get the file name
    public static String getFileName(String textPrompt){
        Scanner input = new Scanner(System.in);
        System.out.print(textPrompt);
        String fileName = input.next();
        return fileName;
    }

    // Encryption method
    public static File encryption(String fileName, File plainFile) throws IOException {
        File encrypted = new File(fileName);
        DataInputStream input = new DataInputStream(new FileInputStream(plainFile));
        DataOutputStream output = new DataOutputStream(new FileOutputStream(encrypted));

        int b = 0;
        b = input.read();
        while (b != -1) {
            int shiftedInt = b + 5;
            char newChar = (char) shiftedInt;
            output.write(newChar);
            b = input.read();
        }
        output.close();
        input.close();
        System.out.println("Encryption complete");

        return encrypted;
    }

    // Decryption method
    public static File decryption(String filename, File encryptedFile) throws IOException {
        File decrypted = new File(filename);
        DataInputStream input = new DataInputStream(new FileInputStream(encryptedFile));
        DataOutputStream output = new DataOutputStream(new FileOutputStream(decrypted));

        int b = 0;
        b = input.read();
        while (b != -1) {
            int shiftedInt = b - 5;
            char newChar = (char) shiftedInt;
            output.write(newChar);
            b = input.read();
        }
        output.close();
        input.close();
        System.out.println("Decryption complete.");

        return decrypted;
    }
}



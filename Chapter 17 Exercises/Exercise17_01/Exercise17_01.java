/**
 * Author: Nate Elison
 * Date: 5/24/23
 *
 * This program creates a new text file called exercise17_01 and writes 100 random integers to it.
 * If the file already exists, the program appends the 100 random integers to the file.
 */

import java.io.*;

public class Exercise17_01 {
    public static void main(String[] args) throws IOException {
        //Create file and printwriter
        File file = new File("Exercise17_01.txt");
        PrintWriter output = new PrintWriter(new FileOutputStream(file, true));

        // Loop to print random int
        for (int i = 0; i < 100; i++){
            int randomInt = (int) (Math.random() * 10);
            output.print(randomInt + " ");
        }
        output.close();
    }
}

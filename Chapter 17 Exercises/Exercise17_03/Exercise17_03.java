/**
 * Author: Nate Elison
 * Date: 5/30/23
 *
 * This program creates two methods, one creates a .dat file and writes 100 random integers to it (writeIntegers).
 * If the .dat file already exists, the new data is appended.
 * The second method reads a .dat file and sums all the integers (getSum).
 * The main method tests these two methods, by creating a new .dat file using writeIngeters and printing the sum by calling getSum.
 */

import java.io.*;

public class Exercise17_03 {
    public static void main(String[] args) throws IOException {
        // Create File using method
        File file = writeIntegers();

        // Sum all integers written to the file and display the total.
        int sum = getSum(file);
        System.out.println("Total: " + sum);
    }

    // Method to create a file, write 100 random integers to file, and return that file.
    public static File writeIntegers() throws IOException {
        // Create file and dataOutputStream
        File file = new File("Exercise17_03.dat");
        DataOutputStream output = new DataOutputStream(new FileOutputStream(file, true));

        // write the 100 random ints
        for (int i = 0; i < 100; i++){
            int randomInt = (int) (Math.random() * 10);
            output.writeInt(randomInt);
        }
        output.close();
        return file;
    }

    // Method to add integers from a file, return the sum
    public static int getSum(File file) throws IOException {
        // Create the data input stream
        DataInputStream input = new DataInputStream(new FileInputStream(file));
        int sum = 0;
        // Read and add ints to the total until there is no more data.
        try {
            while (true){
                int toAdd = input.readInt();
                sum += toAdd;
            }
        }
        // Catch exception thrown when there is no more data and return the total
        catch (EOFException ex){
            System.out.println("All ints summed");
            input.close();
            return sum;
        }
    }
}

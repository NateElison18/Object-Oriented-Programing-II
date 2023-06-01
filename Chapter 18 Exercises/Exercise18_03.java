/**
 * Author: Nate Elison
 * Date: 5/31/23
 * 
 * This program uses recursion to calculate the greatest common divisor (GCD) of two integers.
 * It gets the ints to be checked from the user. 
 */

import java.util.Scanner;

public class Exercise18_03 {
    public static void main(String[] args){
    	// Get the two ints
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer 1: ");
        int m = input.nextInt();
        System.out.print("Enter integer 2: ");
        int n = input.nextInt();

        // Call the recursive gcd method and print the results
        int gcd = gcd(m, n);
        System.out.println("The GCD of " + n + " and " + m + " is: " + gcd);
    }

    // Recursive gcd method
    public static int gcd(int m, int n){
        if (m % n == 0) {
        	return n;
        }
        else {
            return gcd(n, m % n);
        }
    }
}

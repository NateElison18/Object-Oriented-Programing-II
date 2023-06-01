/**
 * Author: Nate Elison
 * Date: 5/31/23
 * 
 * This program gets a string from a user and uses recursion to print it out reversed. 
 */

import java.util.Scanner;

public class Exercise18_09 {

	public static void main(String[] args) {
		// Get the string to be reversed and call the reverse method. 
		Scanner input = new Scanner(System.in);
		System.out.print("Enter string to be reversed: ");
		String value = input.nextLine();
		System.out.println("Reversed: ");
		reverseDisplay(value);

	}
	
	// Reverse display method
	public static void reverseDisplay(String value) {
		reverseDisplay(value, value.length() - 1);
		
	}
	
	// Helper method
	public static void reverseDisplay(String value, int max) {
		// base case
		if (max == 0) {
			System.out.print(value.charAt(max));
			return;
		}
		else {
			System.out.print(value.charAt(max));
			max--;
			reverseDisplay(value, max);
		}
		
	}

}

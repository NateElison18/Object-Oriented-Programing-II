/*
Author: Nate Elison
Date: 6/2/23

This program creates a generic sort method, that takes in an arraylist and sorts it.
The program tests the method by creating an arraylist of integers in random order and prints out the list after running it through the sort method.
*/
import java.util.ArrayList;

public class Exercise19_09 {
    public static void main(String[] args) {

        // Create an array list and test sort method
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(4);
        list.add(42);
        list.add(5);
        Exercise19_09.<Integer>sort(list);

        System.out.print(list);
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {

        // Loop through the entire list, set min and min index at current iteration
        for (int i = 0; i < list.size() - 1; i++) {
           E min = list.get(i);
           int minIndex = i;

           // Compare rest of the objects in the list. If smaller object is found, update the min and min index
            for (int j = i + 1; j < list.size(); j++){
                if (min.compareTo(list.get(j)) > 0) {
                    min = list.get(j);
                    minIndex = j;
                }
            }

            // Swap the min with the object in the min index if necessary
            if (minIndex != i) {
                E placeholder = list.get(i);
                int indexPlaceholder = minIndex;
                list.set(indexPlaceholder, placeholder);
                list.set(i, min);
            }

        }
    }
}

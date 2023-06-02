/**
 * Author: Nate Elison
 * Date: 6/2/23
 *
 * This program creates a generic method that removes duplicates from an arraylist of any type.
 * It tests the method by creating an arraylist of integers with duplicates and running it through the method to print out a new
 * list without duplicates.
 */

import java.util.ArrayList;

public class Exercise19_03 {
    public static void main(String[] args) {
        // Create the test array list
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);
        list.add(14);
        list.add(25);
        list.add(14);
        list.add(77);

        // Make and display new array list using remove duplicates method
        ArrayList<Integer> newList = removeDuplicates(list);

        System.out.print(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        // Create new arraylist and set index 0
        ArrayList<E> listWithoutDupes = new ArrayList<E>();
        listWithoutDupes.add(list.get(0));

        // Loop through original arraylist
        for (int i = 1; i < list.size(); i++) {
            boolean dupe = false;
            // Loop through new arraylist mark any dupe
            for(int j = 0; j < listWithoutDupes.size(); j++) {
                if (list.get(i).equals(listWithoutDupes.get(j))) dupe = true;
            }
            if (dupe == false) listWithoutDupes.add(list.get(i));
        }
        return listWithoutDupes;
    }
}

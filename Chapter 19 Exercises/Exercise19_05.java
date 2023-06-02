/**
 * Author: Nate Elison
 * Date: 6/2/23
 *
 * This program creates a generic method that finds the max in an array.
 * It tests the method by creating different types of arrays and printing out the max in the array.
 */

public class Exercise19_05 {
    public static void main(String [] args) {
        // Create int array and test max method
        Integer[] numbers = {1, 2, 3};
        System.out.println(max(numbers));

        // Create String array and test max method
        String[] words = {"red", "green", "blue"};
        System.out.println(max(words));

        // Create Circle array and test max method
        Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
        System.out.println(max(circles));
    }

    // Max method
    public static <E extends Comparable<E>> E max(E[] list){
        // Create max and set to index 0
        E max = list[0];
        // Loop through and set max to anything larger than current max
        for (int i = 1; i < list.length; i++){
            if (max.compareTo(list[i]) < 0) max = list[i];
        }
        return max;
    }

    static class Circle implements Comparable<Circle> {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public int compareTo(Circle c) {
            if (radius < c.radius)
                return -1;
            else if (radius == c.radius)
                return 0;
            else
                return 1;
        }

        @Override
        public String toString() {
            return "Circle radius: " + radius;
        }
    }
}

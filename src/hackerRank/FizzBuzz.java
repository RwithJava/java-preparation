package hackerRank;

import java.util.stream.IntStream;

public class FizzBuzz {

    /*
     * Will be giving a range (int), when you encounter :
     * multiples of 3 - need to print out "Fizz"
     * multiples of 5 - need to print out "Buzz"
     * multiples of 3 and 5 - need to print out "FizzBuzz"
     * don't consider 0 and for others print the values itself.
     */

    public static void main(String[] args) {
        int range = 15;

        //using for loop
        for (int i = 1; i <= range; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        // functional programming
        IntStream.rangeClosed(1, range)
                .mapToObj(i -> {
                    if (i % 3 == 0 && i % 5 == 0) {
                        return "FizzBuzz"; // If divisible by both 3 and 5
                    } else if (i % 3 == 0) {
                        return "Fizz"; // If divisible by 3
                    } else if (i % 5 == 0) {
                        return "Buzz"; // If divisible by 5
                    } else {
                        return String.valueOf(i); // Otherwise return the number
                    }
                })
                .forEach(System.out::println); // Print each result
    }
}
package interviewQues;

import java.util.List;
import java.util.OptionalInt;

public class DiffBtwMaxAndMin {

    public static void main(String[] args) {

//        Write a Java function that takes a list of integers and returns the difference between the largest and smallest values in the list.
//        The function should handle lists of varying sizes, including edge cases like an empty list or a list with only one element.

        List<Integer> numbers = List.of(4, 2, 9, 7, 5, 6, 3);
        List<Integer> singleElement = List.of(10);
        List<Integer> emptyList = List.of();

        System.out.println(findDifference(numbers));
        System.out.println(findDifference(singleElement));
        System.out.println(findDifference(emptyList));

    }

    private static int findDifference(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        OptionalInt max = numbers.stream().mapToInt(i -> i).max();
        OptionalInt min = numbers.stream().mapToInt(i -> i).min();

        return max.getAsInt() - min.getAsInt();
    }
}

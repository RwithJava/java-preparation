package ds;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
        List<Integer> result = reverseString(numbers);
        System.out.println(result);
    }

    private static List<Integer> reverseString(List<Integer> numbers) {
        return IntStream.range(0,numbers.size()).
                mapToObj(i -> numbers.get(numbers.size()-i-1)).toList();
    }
}

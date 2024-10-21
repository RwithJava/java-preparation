package ds;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
        System.out.println(reverseString(numbers));
        System.out.println(Arrays.toString(reverseStringNormal(numbers)));
    }

    private static int[] reverseStringNormal(List<Integer> numbers) {
        int[] arr = new int[numbers.size()];
        for (int i = numbers.size() - 1; i >= 0; i--) {
            arr[numbers.size() - 1 - i] = numbers.get(i);
            //System.out.println(numbers.get(i));
        }
        return arr;
    }

    private static List<Integer> reverseString(List<Integer> numbers) {
        return IntStream.range(0, numbers.size()).
                mapToObj(i -> numbers.get(numbers.size() - i - 1)).toList();
    }
}

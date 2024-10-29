package interviewQues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurrences {

    public static void main(String[] args) {

        Object[] array = {1, 2, 3, new Object[]{1, 3}, 2, 2, new Object[]{1, 3, 4}};

        //traditional iteration
        Map<Object, Integer> result = new HashMap<>();
        findOccurrence(array, result);
        System.out.println(result);

        //java8
        Map<Object, Long> result1 = countOccurrences(array);
        System.out.println(result1);



    }


    private static void findOccurrence(Object[] array, Map<Object, Integer> result) {

        for (Object element : array) {
            if (element instanceof Object[]) {
                findOccurrence((Object[]) element, result);
            } else {
                result.put(element, result.getOrDefault(element, 0) + 1);
            }
        }

    }

    public static Map<Object, Long> countOccurrences(Object[] array) {
        return flatten(array)
                .collect(Collectors.groupingBy(element -> element, Collectors.counting()));
    }

    public static Stream<Object> flatten(Object[] array) {
        return Arrays.stream(array)
                .flatMap(element -> element instanceof Object[] ? flatten((Object[]) element) : Stream.of(element));
    }
}

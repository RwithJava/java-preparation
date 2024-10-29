package interviewQues;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesObjectArray {

    public static void main(String[] args) {

        Object[] array = {1, 2, 3, new Object[]{1, 3}, 2, 2, new Object[]{1, 3, 4}};

        Map<Object, Integer> result = new HashMap<>();
        countOccurrences(array, result);
        System.out.println(result);

    }

    private static void countOccurrences(Object[] array, Map<Object, Integer> result) {

        for (Object element : array) {
            if (element instanceof Object[]) {
                countOccurrences((Object[]) element, result);
            } else {
                result.put(element, result.getOrDefault(element, 0) + 1);
            }
        }
    }
}

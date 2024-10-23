package Others;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxOccurringValue {

    public static void main(String[] args) {
        List<String> values = List.of("aa", "bb", "cc", "aa", "bb", "aa", "bb");
        System.out.println(getMaxOccurringValue(values));
    }

    private static String getMaxOccurringValue(List<String> values) {
        return values.stream()
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("not unique value found");
    }

}


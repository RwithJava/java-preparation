package interviewQues;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxOccurring {


    public static void main(String[] args) {

        List<String> values = List.of("aa","bb","cc","aa","bb","aa","bb");
        System.out.println(getMaxOccurring(values));
    }

    private static String getMaxOccurring(List<String> values) {

        Map<String,Long> stringAndCount =  values.stream()
                .collect(Collectors.groupingBy(s -> s,Collectors.counting()));


        return stringAndCount.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey) // Get the key from the max entry
                .orElse("");

    }
}

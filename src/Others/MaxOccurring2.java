package Others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxOccurring2 {
    public static void main(String[] args) {

        String sentence = "word1 word2 word3 word1 word2";
        // Max occurring second value : word2

        String word = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().skip(1)
//                .max(Comparator.comparing(Map.Entry::getValue))
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nothing found.");

        System.out.println("first : " + word);

        String word2 = Arrays.stream(sentence.split(" "))
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(i -> i, Collectors.counting()),
                        map -> map.entrySet().stream()
                                .skip(1)
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse("nothing")
                ));

        System.out.println("second : " + word2);

        String word3 = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .reduce((e1, e2) -> e1.getValue() > e2.getValue() || (e1.getValue().equals(e2.getValue()) && e1.getKey().equals(e2.getKey())) ? e1 : e2)
                .map(Map.Entry::getKey)
                .orElse("Nothing found.");

        System.out.println("Most frequent word: " + word3);

        String minWord = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(i->i,Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Nothing");

        System.out.println("Less frequent word: " + minWord);

    }
}

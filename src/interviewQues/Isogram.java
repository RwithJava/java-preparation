package interviewQues;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Isogram {

    // Check the given string is Iso gram or not ? means string could not have any repeating element .
    public static void main(String[] args) {

        String test1 = "English";
        String test2 = "Malayalam";

        System.out.println(IsIsogram(test1));
        System.out.println(IsIsogram(test2));

        System.out.println(IsIsogramwith8(test1));
        System.out.println(IsIsogramwith8(test2));

        System.out.println(IsIsogramwith81(test1));
        System.out.println(IsIsogramwith81(test2));
    }

    private static boolean IsIsogramwith81(String test1) {
        long newLength = test1.chars().distinct().count();
        return newLength == test1.length();
    }

    private static boolean IsIsogram(String str) {

        Set<Character> charSet = new HashSet<>();

        for (char ch : str.toCharArray()) {

            if (charSet.contains(ch)) {
                return false;
            } else {
                charSet.add(ch);
            }
        }
        return true;
    }

    private static boolean IsIsogramwith8(String str) {
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .values().stream()
                .noneMatch(count -> count > 1);
    }
}
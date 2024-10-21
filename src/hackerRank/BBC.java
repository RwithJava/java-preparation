package hackerRank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BBC {

    public static void main(String[] args) {

        String test1 = "(){}";    // Balanced
        String test2 = "({})";    // Balanced
        String test3 = "({)}";    // Not balanced
        String test4 = "{()()}";  // Balanced
        String test5 = "({}";     // Not balanced
        System.out.println(isBalanced(test1));
        System.out.println(isBalanced(test2));
        System.out.println(isBalanced(test3));
        System.out.println(isBalanced(test4));
        System.out.println(isBalanced(test5));

        int[] numbers = {1, 4, 3, 2};
        int[] reversed = reverseArray(numbers);
        System.out.println(Arrays.toString(reversed));

        String s = "word1 word2 word3  word1 word2";
        System.out.println(lengthSkippingSpecialCharacters(s));

        String se = "word1 word2 word3 word1 word2 word4";
        String nonRepeatingWord = nonRepeatingString(se);
        System.out.println(nonRepeatingWord);

        List<String> values = List.of("aa", "bb", "cc", "aa", "bb");
        duplicatesAndCount(values);

        List<String> valuesTray = List.of("A", "B", "C", "123", "Eye", "@#");
        insertPipeSymbol(valuesTray);

        String s1 = "listen";
        String s2 = "silent";
        boolean flag = anagaram(s1, s2);
        System.out.println(flag);

    }

    private static boolean anagaram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] ss1 = s1.toCharArray();
        char[] ss2 = s1.toCharArray();

        Arrays.sort(ss1);
        Arrays.sort(ss2);


        return Arrays.equals(ss1, ss2);


    }

    private static String isBalanced(String brackets) {

        Stack<Character> stack = new Stack<>();

        for (char c : brackets.toCharArray()) {

            if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}') {

                if (stack.isEmpty()) {
                    return "unbalanced";
                }


                char charFromStack = stack.pop();

                if (c == ')' && charFromStack != '(') {
                    return "unbalanced";
                }

                if (c == '}' && charFromStack != '{') {
                    return "unbalanced";
                }

            }


        }
        return stack.isEmpty() ? "balanced" : "unbalanced";
    }

    private static int[] reverseArray(int[] arr) {
        return IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - i - 1])
                .toArray();
    }

    private static int lengthSkippingSpecialCharacters(String s) {
        int length = 0;
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                length++;
            }
        }
        return length;
    }

    private static String nonRepeatingString(String s) {
        String[] sArr = s.split(" ");

        return Arrays.stream(sArr)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().filter(n -> n.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("no element found");
    }

    private static void duplicatesAndCount(List<String> s) {
        s.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .filter(i -> i.getValue() > 1)
                .map(Map.Entry::getKey).forEach(System.out::println);
    }

    private static void insertPipeSymbol(List<String> valuesTray) {
        valuesTray.stream()
                .map(i -> i.length() > 1 ? addSymbol(i) : i)
                .forEach(System.out::println);
    }

    private static String addSymbol(String input) {
        return String.join("|", input.split(""));
    }
}

package hackerRank;

import java.util.*;
import java.util.Deque;

public class BalancedBracketChecker {

    /*
    Question: Balanced Brackets Checker
    Task:
    Implement a Java method called isBalanced(String brackets) that takes a string of brackets as input
    and returns true if the string is balanced and false otherwise.

    A string is considered balanced if:

    Every opening bracket has a corresponding closing bracket.
    Brackets are closed in the correct order.
    The brackets we will consider are:

    Round brackets: ()
    Curly brackets: {}
    For example:

    The string (){}{} is balanced.
    The string ({}) is balanced.
    The string ({)} is not balanced because the order is incorrect.
    The string {()} is balanced.
    The string ({} is not balanced because there is an unmatched opening bracket.


    Constraints:
    The input string can contain only the characters (, ), {, and }.
     */

    public static void main(String[] args) {

        // Test cases
        String test1 = "(){}";    // Balanced
        String test2 = "({})";    // Balanced
        String test3 = "({)}";    // Not balanced
        String test4 = "{()()}";  // Balanced
        String test5 = "({}";     // Not balanced

//        System.out.println(isBalanced(test1)); // Output: true
//        System.out.println(isBalanced(test2)); // Output: true
//        System.out.println(isBalanced(test3)); // Output: false
//        System.out.println(isBalanced(test4)); // Output: true
//        System.out.println(isBalanced(test5)); // Output: false

//        System.out.println(isBalancedList(test1)); // Output: true
//        System.out.println(isBalancedList(test2)); // Output: true
//        System.out.println(isBalancedList(test3)); // Output: false
//        System.out.println(isBalancedList(test4)); // Output: true
//        System.out.println(isBalancedList(test5)); // Output: false

        System.out.println(isBalancedDeque(test1)); // Output: true
        System.out.println(isBalancedDeque(test2)); // Output: true
        System.out.println(isBalancedDeque(test3)); // Output: false
        System.out.println(isBalancedDeque(test4)); // Output: true
        System.out.println(isBalancedDeque(test5)); // Output: false

    }

    private static boolean isBalanced(String brackets) {

        Stack<Character> stack = new Stack<>(); // to store opening brackets

        for (char currentChar : brackets.toCharArray()) {


            if (currentChar == '(' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == '}') {

                //return false if stack is empty
                if (stack.isEmpty()) {
                    return false;
                }

                char charFromStack = stack.pop();

                if ((currentChar == ')' && charFromStack != '(') || (currentChar == '}' && charFromStack != '{')) {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

    private static String isBalancedList(String brackets) {
        List<Character> list = new LinkedList<>();  // Use List as a stack

        for (char c : brackets.toCharArray()) {

            if (c == '(' || c == '{') {
                list.add(c);
            }

            else if (c == ')' || c == '}') {
                if (list.isEmpty()) return "Not Balanced";

                char openBracket = list.removeLast();
                if ((c == ')' && openBracket != '(') || (c == '}' && openBracket != '{')) {
                    return "Not Balanced";
                }
            }
        }


        return list.isEmpty() ? "Balanced" : "Not Balanced";
    }

    public static String isBalancedDeque(String brackets) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : brackets.toCharArray()) {

            if (c == '(' || c == '{') {
                deque.push(c);
            }

            else if (c == ')' || c == '}') {
                if (deque.isEmpty()) return "Not Balanced";

                char openBracket = deque.pop();
                if ((c == ')' && openBracket != '(') || (c == '}' && openBracket != '{')) {
                    return "Not Balanced";
                }
            }
        }


        return deque.isEmpty() ? "Balanced" : "Not Balanced";
    }

}

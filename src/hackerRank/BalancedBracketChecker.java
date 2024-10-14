package hackerRank;

import java.util.Stack;

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

        System.out.println(isBalanced(test1)); // Output: true
        System.out.println(isBalanced(test2)); // Output: true
        System.out.println(isBalanced(test3)); // Output: false
        System.out.println(isBalanced(test4)); // Output: true
        System.out.println(isBalanced(test5)); // Output: false

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

}

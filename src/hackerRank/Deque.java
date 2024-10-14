package hackerRank;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Deque {

    //Ques : which ds can erase in the beginning and end in 0(1)

    /*
     * In Java, a data structure that can efficiently erase elements from both the beginning and the end in constant time,
     *  i.e., O(1), is **`Deque`** (Double-Ended Queue), specifically implementations like:

    ### 1. `ArrayDeque`:
    - `ArrayDeque` is a resizable array that can add or remove elements from both ends in constant time.
    - It does not have capacity limitations and is faster than `LinkedList` for deque operations.
    - It is part of the Java Collections Framework.

    ### 2. `LinkedList`:
    - `LinkedList` also implements `Deque` and provides constant-time insertion and deletion from both ends.
    - It is based on a doubly-linked list.

    ### Why `Deque`?
    - **O(1) time complexity**: Operations like `addFirst`, `addLast`, `removeFirst`, and `removeLast` all operate in constant time.
    - **Double-ended operations**: It allows insertion and deletion from both the front and the rear.

    Hence, for constant-time (O(1)) operations at both ends, **`ArrayDeque`** or **`LinkedList`** (both implementing `Deque`) are the best choices in Java.
     */


}

class DequeLinkedListExample {
    public static void main(String[] args) {
        // Create a deque (LinkedList)
        java.util.Deque<Integer> deque = new LinkedList<>();

        // Adding elements at the end and the beginning
        deque.addFirst(1); // Add 1 at the beginning
        deque.addLast(2);  // Add 2 at the end
        deque.addFirst(0); // Add 0 at the beginning

        System.out.println("Deque: " + deque); // Output: [0, 1, 2]

        // Removing elements from the beginning and the end
        deque.removeFirst(); // Remove 0 from the beginning
        deque.removeLast();  // Remove 2 from the end

        System.out.println("Deque after removals: " + deque); // Output: [1]
    }
}

class DequeExample {
    public static void main(String[] args) {
        // Create a deque (ArrayDeque)
        java.util.Deque<Integer> deque = new ArrayDeque<>();

        // Adding elements at the end and the beginning
        deque.addFirst(1); // Add 1 at the beginning
        deque.addLast(2);  // Add 2 at the end
        deque.addFirst(0); // Add 0 at the beginning

        System.out.println("Deque: " + deque); // Output: [0, 1, 2]

        // Removing elements from the beginning and the end
        deque.removeFirst(); // Remove 0 from the beginning
        deque.removeLast();  // Remove 2 from the end

        System.out.println("Deque after removals: " + deque); // Output: [1]
    }
}
package interviewQues;

import java.util.LinkedList;
import java.util.ListIterator;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

        // Write a Java program to find the middle element of a LinkedList in a single pass.
        // You should not traverse the LinkedList more than once.
        // If the LinkedList has an odd number of elements, return the middle element.
        // If it has an even number of elements, return the first middle element.
        // If the list is empty, return null.

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        findMiddle(list);

    }

    private static void findMiddle(LinkedList<Integer> list) {

        if (list == null || list.isEmpty()) {
            System.out.println("NULL");
            return;
        }

        ListIterator<Integer> slow = list.listIterator();
        ListIterator<Integer> fast = list.listIterator();

        while (fast.hasNext()) {
            fast.next();
            if (fast.hasNext()) {
                fast.next();
                slow.next();
            }
        }


        // in case if we have even elements in the list. As of now we are out of the loop. the pointer will be pointing to 3.
        // hence slow.next will be 4 and slow.previous will be 3

        System.out.println(slow.previous());
//        System.out.println(slow.next());


    }
}

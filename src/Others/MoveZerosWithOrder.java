package Others;

import java.util.Arrays;

public class MoveZerosWithOrder {

    public static void main(String[] args) {

        /*

         1.  Problem Statement :
        You are given an array of integers where some elements are zeros, and others are non-zero integers.
        Your task is to write a Java function that rearranges the array such that all zeros are moved
        to the beginning of the array while maintaining the relative order of the non-zero elements.

                For example, given the input array {0, 1, 0, 2, 0, 3}, the output should be {0, 0, 0, 1, 2, 3}.

        Requirements:

        The function should return a new array with the required arrangement.
        The function should maintain the relative order of the non-zero elements.
        You should not use any additional libraries or frameworks beyond standard Java.

        Function Signature:

                public static int[] rearrangeArray(int[] arr)

       Example:
                Input: arr = {0, 1, 0, 2, 0, 3}
                Output: [0, 0, 0, 1, 2, 3]

       Additional Information:

       Explain the time and space complexity of your solution.
       Provide a test case to validate your function.

Follow-up Question:

How would your solution change if you were required to rearrange the elements in-place without using extra space for the output array?
         */


        int[] numbers = {0,1,0,2,0,3};
        int[] reArranged = getItArranged(numbers);

        System.out.println(Arrays.toString(reArranged)); // [0, 0, 0, 1, 2, 3]


        // Test case
        int[] testArray = {0, 1, 0, 2, 0, 3};
        int[] expectedOutput = {0, 0, 0, 1, 2, 3};

        rearrangeArrayInPlace(testArray);
        System.out.println(Arrays.equals(testArray, expectedOutput) ? "Test Passed :{0, 0, 0, 1, 2, 3}" : "Test Failed :{0, 1, 0, 2, 0, 3}");
    }

    private static int[] getItArranged(int[] numbers) {

        int length = numbers.length;
        int[] arranged = new int[length];   // array with same size as the input
        int index = length - 1;

        // Traverse the array from end to start to place non-zero elements at the end
        for(int i = length - 1; i>=0;i--){
            if(numbers[i]!=0){
                arranged[index--] = numbers[i];
            }
        }

        // Remaining positions in result are already zero as int[] is initialized with zeros
        return arranged;
    }

    /*
    Explanation:

Initialization: The result array is initialized with zeros, and index is set to the last position of the array.

Placement of Non-Zero Elements: The array is traversed from end to start, and non-zero elements are placed from the end of the result array.

Zeros Handling: Since the result array is initialized with zeros, there is no need to explicitly place zeros; they are already in place.

Time Complexity:The time complexity of this solution is 𝑂(𝑛)
O(n) because it involves a single pass through the array to place non-zero elements.

Space Complexity:
The space complexity is 𝑂(𝑛)
O(n) because we are using an additional array of the same size as the input array.

     */

    /*
    Follow-up (In-place Rearrangement):

To rearrange the elements in-place without using extra space for the output array, you can use a two-pointer approach:
     */
    public static void rearrangeArrayInPlace(int[] arr) {
        int n = arr.length;
        int writeIndex = n - 1;

        // Traverse the array from end to start to place non-zero elements at the end
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[writeIndex--] = arr[i];
            }
        }

        // Fill the remaining positions with zeros
        while (writeIndex >= 0) {
            arr[writeIndex--] = 0;
        }
    }

    /*
    Explanation (In-place):

Initialization: Use a writeIndex to keep track of the position where the next non-zero element should be written.

Placement of Non-Zero Elements: Traverse the array from end to start, writing non-zero elements to the end of the array.

Zeros Handling: After placing all non-zero elements, fill the remaining positions at the start of the array with zeros.

Time Complexity:
The time complexity of this in-place solution is 𝑂(𝑛)
O(n) because it involves a single pass through the array to place non-zero elements and another pass to fill zeros.

Space Complexity:
The space complexity is 𝑂(1)
O(1) since no additional array is used.
     */
}

class MyClass {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodWithMultipleLocks() {
        synchronized (lock1) {
            // Code synchronized on lock1
            System.out.println("Lock 1 acquired by " + Thread.currentThread().getName());
        }

        synchronized (lock2) {
            // Code synchronized on lock2
            System.out.println("Lock 2 acquired by " + Thread.currentThread().getName());
        }
    }
}



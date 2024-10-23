package interviewQues;

import java.util.Arrays;

public class RearrangeElements {

    public static void main(String[] args) {

//        1.  Problem Statement :
//                You are given an array of integers where some elements are zeros, and others are non-zero integers.
//                Your task is to write a Java function that rearranges the array
//                such that all zeros are moved to the beginning of the array while maintaining the relative order of the non-zero elements.
//
//                For example,
//                given the input array {0, 1, 0, 2, 0, 3},
//                the output should be {0, 0, 0, 1, 2, 3}.

        int[] numbers = {0, 1, 0, 2, 0, 3};

        System.out.println(Arrays.toString(arranged(numbers)));
        System.out.println(Arrays.toString(arranged1(numbers)));
    }

    private static int[] arranged1(int[] numbers) {

        int length = numbers.length;
        int writeIndex = length - 1;
        int[] arranged = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            if (numbers[i] != 0) {
                arranged[writeIndex--] = numbers[i];
            }
        }

        return arranged;
    }

    private static int[] arranged(int[] numbers) {

        int length = numbers.length;
        int writeIndex = length - 1;

        for (int i = length - 1; i >= 0; i--) {
            if (numbers[i] != 0) {
                numbers[writeIndex--] = numbers[i];
            }
        }

        while (writeIndex >= 0) {
            numbers[writeIndex--] = 0;
        }

        return numbers;
    }


}

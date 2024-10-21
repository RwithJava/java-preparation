package ds;

import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSort(int[] numbers) {

        int n = numbers.length;
        boolean swapped = false;

        for (int i = 0; i < n - 1; i++) {

            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

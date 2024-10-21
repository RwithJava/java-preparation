package interviewQues;

import java.util.stream.IntStream;

public class ContiguousSubArray {

    // finding the minimum length of a contiguous sub array whose sum is at least equal to a given target

    public static void main(String[] args) {
        int[] numbs = {2, 3, 1, 2, 4, 3};
        int[] numbs1 = {1,2,3,4,5};
        int target = 5;
        int result = getArraylength(target, numbs);
        int result1 = minSubArrayLength(target, numbs1);
        System.out.println("Minimum length sub array: " + result);
        System.out.println("Minimum length sub array: " + result1);
    }

    private static int minSubArrayLen(int target, int[] numbs) {

        int start = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int end =0;end<numbs.length;end++){

            currentSum+=numbs[end];

            while (currentSum >= target){
                minLength = Math.min(minLength,end-start+1);

                System.out.println("Sub array from index " +
                        start + " to " + end +
                        " with sum " + currentSum +
                        " has length " + (end - start + 1));


                currentSum -= numbs[start];
                start++;
            }

        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    private static int minSubArrayLength(int target, int[] numbs){

        int[] start = {0};
        int[] currentSum = {0};
        int[] minLength = {Integer.MAX_VALUE};

        IntStream.range(0,numbs.length).forEach(
                end -> {
                    currentSum[0] += numbs[end];

                    while(currentSum[0]>=target){
                        minLength[0] = Math.min(minLength[0],end-start[0]+1);
                        currentSum[0] -= numbs[start[0]];
                        start[0]++;
                    }

        });

        return (minLength[0] == Integer.MAX_VALUE) ? 0 : minLength[0];
    }

    private static int getArraylength(int target, int[] numbs){

        int start = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int end = 0; end<numbs.length;end++){

            //adding first value to sum
            currentSum  += numbs[end];

            while(currentSum >= target){
                minLength = Math.min(minLength,end-start+1);
                currentSum -= numbs[start];
                start++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

}

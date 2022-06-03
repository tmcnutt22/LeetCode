package Grokking.slidingWindow;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] input = new int[] {2, 1, 5, 1, 3, 2};
        int k = 3;
        //Output: 9


        /*
        int[] input = new int[]{2, 3, 4, 1, 5};
        int k = 2;
        //output: 7
         */
        System.out.println(findMaxSubarrayOfSizeK(k, input));
    }
    public static int findMaxSubarrayOfSizeK(int k, int[] arr) {
        int result = Integer.MIN_VALUE;
        int currSum = 0;
        int windowBeginning = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
           currSum += arr[windowEnd];
           if (windowEnd >= k - 1) {
               result = Math.max(result, currSum);
               currSum -= arr[windowBeginning];
               windowBeginning++;
           }
        }
        return result;
    }

    /* understand
    match: sliding window
    plan
     */
}

package Grokking.slidingWindow;

import java.util.Arrays;

class AverageOfSubArrayOfSizeK {
    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0; //basically a pointer to the first index in the window
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element

            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) { // - 1 becquse of zero indexing
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                // this will keep the sum of the last 4 prior to the next integer being added
                windowStart++; // slide the window ahead the for loop will increment the end pointer of the window
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubArrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
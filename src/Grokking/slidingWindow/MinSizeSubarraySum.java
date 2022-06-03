package Grokking.slidingWindow;

public class MinSizeSubarraySum {
    public static void main(String[] args) {
        /*
        int[] nums = new int[] {2,3,1,2,4,3};
        int target = 7;
        //2

        int[] nums = new int[] {1,4,4};
        int target = 4;
        //1

         */

        int[] nums = new int[] {1,1,1,1,1,1,1,1};
        int target = 11;
        //0
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        //O(n) time | O(1) space

        int minLen = Integer.MAX_VALUE;
        int windowBeg = 0;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            //windowSum is >= target
            while (windowSum >= target) {
                minLen = Math.min(minLen, windowEnd - windowBeg + 1);
                windowSum -= nums[windowBeg++]; //this works because it takes windowBeg first, does the math then increments
                //windowBeg++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    /*
    plan:
    sliding window
    slide out the end window until the sum is >= the target
    windowSum += arr[windowEnd]
    record the length (window end - window beg + 1)
    subtract arr[begwindow]
    begwindow++
        while windowSum >= target
        subtract windowSum -= arr[begwindow]
        if windowSum >= target
            math.min(currLen, windowEnd - windowSum + 1)
        begwindow++

     */
}

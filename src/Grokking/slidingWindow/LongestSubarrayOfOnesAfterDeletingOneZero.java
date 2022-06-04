package Grokking.slidingWindow;

public class LongestSubarrayOfOnesAfterDeletingOneZero {
    public static void main(String[] args) {

        int[] nums = new int[]{1,1,0,1};
        int[] nums2 = new int[]{0,1,1,1,0,1,1,0,1};
        int[] nums3 = new int[]{1,1,1};
        int[] nums4 = new int[]{1,1,0,0,1,1,1,0,1};//4
        int[] nums5 = new int[]{0,0,0};
        int[] nums6 = new int[]{1,0,0,1,0};
        int[] nums7 = new int[]{0,0,1,1};
        int[] nums8 = new int[]{0,1,1,1,0,1,1};
        System.out.println(longestSubarray(nums8));
    }

    public static int longestSubarray(int[] nums) {
        boolean deleted = false;
        int windowStart = 0;
        int windowEnd = 0;
        int longest = 0;

        while(windowEnd < nums.length) {
            //tracks the first zero
            if(nums[windowEnd] == 0 && !deleted) {
                deleted = true;
            }
            //if this is the 2nd zero
            else if(nums[windowEnd] == 0 && deleted) {
                //move beginning pointer until it hits a zero
                while(deleted) {
                    if(nums[windowStart] == 0) {
                        deleted = false;
                    }
                    windowStart++;
                }
                //back up one index from the end to count the 0
                windowEnd--;
            }
            longest = Math.max(longest, windowEnd - windowStart);
            windowEnd++;
        }
        return longest;
    }
    /*
     * UMPIRE
     * understand - need to remove one digit even if there are all 1s
     * Match - sliding window
     * Plan
     * Track count of 1s where there is max 1 0. track index of 1st zero in subarray
     * if 2 zeros, move beginning to the index after first 0. update current len and repeat
     */
}

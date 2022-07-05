package Leetcode.HashTable;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }


        //set up some criteria that would be a starting point of a consecutive streak
        //and loop through if it is only a starting point
        int maxLen = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (!set.contains(nums[i] - 1)) {
                int currLen = 1;

                int startingInt = nums[i];
                //nested while loop as this is a starting point
                while (set.contains(startingInt + 1)) {
                    currLen++;
                    startingInt++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}

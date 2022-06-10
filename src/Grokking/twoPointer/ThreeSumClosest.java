package Grokking.twoPointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        //answer: 2
        int[] nums2 = new int[]{0, 0, 0};
        int target2 = 1;
        //answer: 0
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDifferenceSum = Integer.MAX_VALUE;
        for (int indexOne = 0; indexOne < nums.length - 2; indexOne++) {
            if (indexOne > 0 && nums[indexOne] == nums[indexOne -1]) {
                continue;
            }
            int indexTwo = indexOne + 1;
            int indexThree = nums.length - 1;
            while(indexTwo < indexThree) {
                int currSum = nums[indexOne] + nums[indexTwo] + nums[indexThree];
                if (Math.abs(currSum - target) < minDifferenceSum) {
                    minDifferenceSum = currSum;
                } else if (currSum > target) {
                    indexThree--;
                } else {
                    indexTwo++;
                }
            }
        }
        return minDifferenceSum;
    }
}

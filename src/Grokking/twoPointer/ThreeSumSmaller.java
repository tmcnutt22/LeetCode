package Grokking.twoPointer;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,8,1};//{1,2,3,5,8}
        int target = 7;
        System.out.println(threeSumSmaller(nums, target));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private static int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        //System.out.println(sum);
        return sum;
    }
}

/*
UMPIRE
Understand:
- time and space resitrctions?
- is every triplet that satisfies i < j < k < n and i+j+K < target count or
    just the closest to the target but less than the target? assume yes
- will the array be sorted each time like the examples? assume no
- [] or [0] or [0, 1] return 0?
- will each int be different like in the examples?
Match:
since i < j < k < n sort the array
since k < n, create a pointer to the last possible number in the array

Plan
Implement
Review
Evaluate:
 */
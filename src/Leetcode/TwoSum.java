package Leetcode;

import java.util.HashMap;

public class TwoSum {
    //run-time O(n)
    //Space O(n) as the HashMap stores up to n key value pairs

    public static void main(String[] args) {
       int[] intArray = new int[] {2, 7, 11, 15};
       int target = 9;
       System.out.println(twoSum(intArray, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (hashMap.containsKey(difference)) {
                return new int[]{hashMap.get(difference),i};
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

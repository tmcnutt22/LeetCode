package Grokking.twoPointer;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /*
        List<List<Integer>> retList = new ArrayList<>();
        Arrays.sort(nums); //sort the array to use the pointers
        int index = 0; //will be changed to j+1
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 1; j < nums.length -1; j++) {
                if (nums[j] != nums[i]) {
                    index = j + 1;
                    while (index < nums.length) {
                        if (nums[index] != nums[j] && nums[i] + nums[j] + nums[index] == 0) {
                            ArrayList<Integer> tempList = new ArrayList<>();
                            tempList.add(nums[i]);
                            tempList.add(nums[j]);
                            tempList.add(nums[index]);
                            retList.add(tempList);
                            index++;
                        }
                    }
                    // while loop
                }
            }
        }
        return retList;

         */
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int num1Idx = 0; num1Idx < nums.length - 2; num1Idx++) {
            // Skip all duplicates from left
            // num1Idx>0 ensures this check is made only from 2nd element onwards
            if (num1Idx > 0 && nums[num1Idx] == nums[num1Idx - 1]) {
                continue;
            }

            int num2Idx = num1Idx + 1;
            int num3Idx = nums.length - 1;
            while (num2Idx < num3Idx) {
                int sum = nums[num2Idx] + nums[num3Idx] + nums[num1Idx];
                if (sum == 0) {
                    // Add triplet to result
                    result.add(Arrays.asList(nums[num1Idx], nums[num2Idx], nums[num3Idx]));
                    num3Idx--;
                    // Skip all duplicates from right
                    while (num2Idx < num3Idx && nums[num3Idx] == nums[num3Idx + 1]) {
                        num3Idx--;
                    }
                } else if (sum > 0) {
                    // Decrement num3Idx to reduce sum value
                    num3Idx--;
                } else {
                    // Increment num2Idx to increase sum value
                    num2Idx++;
                }
            }
        }
        return result;
    }
}

/*
 *
 * Given an integer array nums, return all the triplets 
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

UMPIRE
U
M - sort the array, track pointers and iterator, once there is a match, move iterator

*/

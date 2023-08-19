package Leetcode.DP.Memoization;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSumRecursive {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(bestSum(7, new int[]{5,3,4,7}));
        System.out.println(bestSum(8, new int[]{5,3,2}));
        System.out.println(bestSum(8, new int[]{5,4,1}));
        System.out.println(bestSum(30, new int[]{1,2,5,26}));
        long endTime = System.currentTimeMillis();
        System.out.println("Time to complete: " + (endTime - startTime));
    }

    public static ArrayList<Integer> bestSum(int target, int[] nums) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        ArrayList<Integer> shortestCombo = null;

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            ArrayList<Integer> remainderCombos = bestSum(remainder, nums);
            if (remainderCombos != null) {
                ArrayList<Integer> combo = new ArrayList<>(remainderCombos);
                combo.add(nums[i]);
                if (shortestCombo == null || combo.size() < shortestCombo.size()) {
                    shortestCombo = combo;
                }
            }
        }
        return shortestCombo;
    }
}

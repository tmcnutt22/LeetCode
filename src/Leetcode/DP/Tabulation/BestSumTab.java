package Leetcode.DP.Tabulation;

import java.util.ArrayList;
import java.util.List;

public class BestSumTab {
    public static List<Integer> bestSum(int target, int[] nums) {
        ArrayList<Integer>[] dp = new ArrayList[target + 1];
        dp[0] = new ArrayList<>();
        int len = dp.length;

        for (int i = 0; i <= target; i++) {
            if (dp[i] != null) {
                for (int num : nums) {
                    int combinationSum = i + num;
                    if (combinationSum <= target) {
                        ArrayList<Integer> newCombination = new ArrayList<>(dp[i]);
                        newCombination.add(num);

                        // If no combination exists or the new one is shorter, update
                        if (dp[combinationSum] == null || newCombination.size() < dp[combinationSum].size()) {
                            dp[combinationSum] = newCombination;
                        }
                    }
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(8, new int[]{5, 3, 2}));
        System.out.println(bestSum(8, new int[]{5, 4, 1}));
        System.out.println(bestSum(30, new int[]{1, 2, 5, 26}));
    }
}

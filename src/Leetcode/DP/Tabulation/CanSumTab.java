package Leetcode.DP.Tabulation;

public class CanSumTab {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{5, 3, 4}));
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(300, new int[]{7, 14}));
    }

    public static boolean canSum(int target, int[] nums) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (dp[i]) {
                    if (i + num < dp.length) {
                        dp[i + num] = true;
                    }
                }
            }
        }

        return dp[target];
    }
}

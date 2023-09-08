package Leetcode.DP.twoDimensional;

import java.util.Arrays;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        print2dArray(dp);
        System.out.println("\n\nIn the loop:");

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
            print2dArray(dp);
        }
        System.out.println("Final");
        print2dArray(dp);
        return Math.abs(S) > total ? 0 : dp[nums.length - 1][S + total];
    }

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }

    public static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                if (j != arr[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

package Leetcode.DP.Tabulation;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

public class HowSumTab {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        /*
        System.out.println("\n" + howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println("\n" + howSum(7, new int[]{2, 3}));
        System.out.println("\n" + howSum(7, new int[]{2, 4}));
        System.out.println("\n" + howSum(3000, new int[]{7, 14}));
        System.out.println("\n" + howSum(8, new int[]{2, 3, 5}));
         */
        howSum(7, new int[]{5, 3, 4, 7});
        howSum(7, new int[]{2, 3});
        howSum(7, new int[]{2, 4});
        howSum(3000, new int[]{7, 14});
        howSum(99991, new int[]{7, 14});
        long endTime = System.currentTimeMillis();
        System.out.println("Time to complete: " + (endTime - startTime));
    }

    public static List<Integer> howSum(int target, int[] nums) {
        ArrayList<Integer>[] dp = new ArrayList[target + 1];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != null) {
                for (int num : nums) {
                    if (i + num < dp.length) {
                        dp[i + num] = new ArrayList<>(dp[i]);
                        dp[i + num].add(num);
                    }
                }
            }
        }

        return dp[target];
    }
}

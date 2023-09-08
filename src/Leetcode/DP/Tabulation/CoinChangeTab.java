package Leetcode.DP.Tabulation;

import java.util.Arrays;

public class CoinChangeTab {
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n == 1 && coins[0] == 1) {
            return amount;
        }
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            if (dp[i] >= 0) {
                for (int coin: coins) {
                    if (i + coin <= amount) {
                        if (dp[i + coin] > 0) {
                            dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                        } else {
                            dp[i + coin] = dp[i] + 1;
                        }
                    }
                }
            }
        }

        if (dp[n] == 0) {
            return -1;
        }

        System.out.println("DP array");
        for(int i: dp) {
            System.out.print(i + ", ");
        }
        return dp[n];
    }

    public static void main(String[] args) {
        coinChange(new int[]{2}, 4);
    }
}

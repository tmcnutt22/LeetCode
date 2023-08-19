package Leetcode.DP.Tabulation;

public class FibTab {
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
    }

    public static long fib(int n) {
        long[] dp = new long[n + 1];
        //seed values
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 0; i < dp.length; i++) {
            if (i + 2 < dp.length) {
                dp[i + 2] += dp[i];
            }
            if (i + 1 < dp.length) {
                dp[i + 1] += dp[i];
            }
        }

        return dp[n];
    }

}

package Leetcode.DP.Memoization;

import java.util.ArrayList;

public class CoinChange {
    public static void main (String[] args) {
        System.out.println(coinChange(11, new int[]{1, 2, 5}));
    }

    public static int coinChange(int amount, int[] coins) {
        ArrayList<Integer> list = coinChangeHelper(amount, coins);
        if (list != null) {
            return list.size();
        }
        return -1;
    }

    public static ArrayList<Integer> coinChangeHelper(int amount, int[] coins) {
        //base cases
        if (amount == 0) {
            return new ArrayList<>();
        }

        if (amount < 0) {
            return null; //think about this one
        }

        ArrayList<Integer> shortest = null;

        for (int coin: coins) {
            int remainder = amount - coin;
            ArrayList<Integer> remainderCoins = coinChangeHelper(remainder, coins);
            if (remainderCoins != null) {
                ArrayList<Integer> coinCounts = new ArrayList<>(remainderCoins);
                coinCounts.add(coin);
                //System.out.println(coinCounts);
                if (shortest == null || coinCounts.size() < shortest.size()) {
                    shortest = coinCounts;
                }
            }
        }

        return shortest;
    }
}

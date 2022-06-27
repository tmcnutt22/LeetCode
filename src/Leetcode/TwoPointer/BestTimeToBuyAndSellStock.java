package Leetcode.TwoPointer;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int left = 0;
        int right = 1;
        int profit = 0;

        while (left < right && right < prices.length) {
            if (prices[right] <= prices[left]) {
                left = right;
                right++;

            } else {
                profit = Math.max(profit, prices[right] - prices[left]);
                right++;
            }
        }
        return profit;
    }
}

/*
O(n) time where n is the size of the array
O(1) space as there is no additional memory used
 */

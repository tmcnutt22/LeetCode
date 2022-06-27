package Leetcode.TwoPointer;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int totalProfit = 0;
        if (n == 1) return totalProfit;
        //pointers
        int left = 0;
        int right = 1;
        while (right < n) {
            if (prices[right] > prices[left]) {
                totalProfit += prices[right] - prices[left];
            }
            left++;
            right++;
        }

        return totalProfit;
    }
}

/*
UMPIRE
Understand:
- empty array or array of 1?
-
Match:
Two pointers
Greedy:

Plan:
greedy approach in that every time there is a profit in a day we take it
two points left -> index 0 and right -> index 1
track totalProfit

while loop (right < len):
    if (profit[r] > profit[l]:
        profit += price[r] - price[l]

    left = right
    right++
returm totalProfit
 */

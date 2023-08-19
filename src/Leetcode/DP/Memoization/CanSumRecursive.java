package Leetcode.DP.Memoization;

public class CanSumRecursive {
    public static boolean canSum(int target, int[] nums) {
        //base cases
        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        for (int num: nums) {
            int remainder = target - num;
            if (canSum(remainder, nums)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{5, 3, 4}));
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(3019, new int[]{7, 14}));
    }
}

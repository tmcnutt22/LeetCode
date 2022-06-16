package Leetcode.HashTable;

public class MissingNumber {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int total = (n*(n+1))/2;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return total - sum;

        /*
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
        */
    }
    /*
    O(n) time | O(1) space
     */
}

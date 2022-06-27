package Leetcode.HashTable;

public class CheckNumIsMajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        if (target < nums[0]) return false;
        int n = nums.length;
        if (n == 1) {
            if (nums[0] == target) {
                return true;
            } else {
                return false;
            }
        }

        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (num == target && map.get(num) > n /2) {
                return true;
            }
        }
        */
        //move until we hit target
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[index] == target) {
                break;
            }
            index++;
        }
        //edge case
        if (index == n) return false;

        //set a counter and compare to n / 2
        int targetCount = 0;
        while (index < n && nums[index] == target) {
            targetCount++;
            index++;
        }

        return targetCount > n /2;
    }
}

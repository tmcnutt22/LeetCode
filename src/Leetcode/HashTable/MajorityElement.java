package Leetcode.HashTable;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        //key is the num, value is the count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return 0; //will never hit this
    }
}

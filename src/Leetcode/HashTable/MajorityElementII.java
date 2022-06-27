package Leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        if (nums.length == 1) {
            retList.add(nums[0]);
            return retList;
        }

        int n = nums.length;
        int oneThird = n / 3;

        HashMap<Integer, Integer> map = new HashMap<>(); //key is num, val is count

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > oneThird && !retList.contains(num)){
                retList.add(num);
            }
        }
        return retList;
    }
}

package Leetcode.HashTable;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //edge cases
        if (nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        //key is the num, val is most recent index of the number
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                //check the difference of the indices

                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                } else { //replace the existing value for the num to the current index
                    map.replace(nums[i], i);
                }
            } else { // key is not in map
                map.put(nums[i], i);
            }
        }
        // if we loop the whole array and it doesn't return, then there are no matches that satisfy
        return false;
    }
    //O(n) time and space where n is the size of the array
}

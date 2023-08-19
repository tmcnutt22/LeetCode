package Leetcode.DP.Memoization;
import java.util.HashMap;

public class canSumMemo {
    public static void main (String[] args) {
        System.out.println(canSumHelper(7, new int[]{2,3}, new HashMap<>())); //true
        System.out.println(canSumHelper(7, new int[]{5, 3, 4, 7}, new HashMap<>())); //true
        System.out.println(canSumHelper(7, new int[]{2, 4}, new HashMap<>())); //false
        System.out.println(canSumHelper(7, new int[]{2, 3, 5}, new HashMap<>())); //true
        System.out.println(canSumHelper(3000, new int[]{7, 14}, new HashMap<>())); //false
    }

    public static boolean canSumHelper(int target, int[] nums, HashMap<Integer, Boolean> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) return true;
        if (target < 0) return false;

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (canSumHelper(remainder, nums, map)) {
                map.put(target, true);
                return true;
            }
        }
        map.put(target, false);
        return false;
    }
}

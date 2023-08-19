package Leetcode.DP.Memoization;
import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        /*
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{2, 4}));
        System.out.println(howSum(3000, new int[]{7, 14}, map));
        System.out.println(howSum(8, new int[]{2, 3, 5}, map));
         */
    }

    public static ArrayList<Integer> howSum(int target, int[] nums, HashMap<Integer, ArrayList<Integer>> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        for (int num : nums) {
            int remainder = target - num;
            ArrayList<Integer> remainderResult = howSum(remainder, nums, map);
            if (remainderResult != null) {
                remainderResult.add(num);
                map.put(target, remainderResult);
                return remainderResult;
            }
        }
        map.put(target, null);
        return null;
    }
}

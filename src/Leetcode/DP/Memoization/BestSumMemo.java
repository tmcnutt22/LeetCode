package Leetcode.DP.Memoization;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSumMemo {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5,3,4,7}, new HashMap<Integer, ArrayList<Integer>>()));
        System.out.println(bestSum(8, new int[]{5,3,2}, new HashMap<Integer, ArrayList<Integer>>() ));
        System.out.println(bestSum(8, new int[]{5,4,1}, new HashMap<Integer, ArrayList<Integer>>() ));
        System.out.println(bestSum(603, new int[]{1,2,5,25}, new HashMap<Integer, ArrayList<Integer>>()));
    }

    public static ArrayList<Integer> bestSum(int target, int[] nums, HashMap<Integer, ArrayList<Integer>> map) {
        if (map.containsKey(target)) return map.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        ArrayList<Integer> shortestCombo = null;

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            ArrayList<Integer> remainderCombos = bestSum(remainder, nums, map);
            if (remainderCombos != null) {
                ArrayList<Integer> combo = new ArrayList<>(remainderCombos);
                combo.add(nums[i]);
                if (shortestCombo == null || combo.size() < shortestCombo.size()) {
                    shortestCombo = combo;
                }
            }
        }
        map.put(target, shortestCombo);
        return shortestCombo;
    }
}

package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<Integer>(), candidates, target, 0);
        return output;
    }

    public void backtrack(int num, List<Integer> curr, int[] candidates, int target, int total) {
        if (num > candidates.length - 1 || total > target) {
            return;
        }

        if (total == target) {
            output.add(new ArrayList<Integer>(curr));
            return;
        }

        curr.add(candidates[num]);

        //repeating decision
        backtrack(num, curr, candidates, target, total + candidates[num]);
        if (!curr.isEmpty()) {
            curr.remove(curr.size() - 1);
        }

        backtrack(num + 1, curr, candidates, target, total);
    }
}

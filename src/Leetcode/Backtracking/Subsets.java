package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> output = new ArrayList(); //return list
    int n, k; //n is size of nums; k is the current size limit we are looking for

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        for (k = 0; k < n + 1; k++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }



        return output;

    }

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        //base case
        if (curr.size() == k) {
            output.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = first; i < n; i++) {
            //add i into the current combination / list
            curr.add(nums[i]);

            // use the next int to complete the combination
            backtrack(i + 1, curr, nums);
            //backtrack - remove the last item in the current list
            curr.remove(curr.size() - 1);
        }
    }
}

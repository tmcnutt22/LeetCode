package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    // n is the target sum
    // k is the number of elements
    List<List<Integer>> output = new ArrayList<>();
    int target;
    int elements;

    public List<List<Integer>> combinationSum3(int k, int n) {
        target = n;
        elements = k;

        backtrack(0, 0, new ArrayList<>());
        return output;
    }


    public void backtrack(int digit, int total, List<Integer> curr) {
        //return cases
        if (curr.size() > elements || total > target) {
            return;
        }

        //base case
        if (total == target && curr.size() == elements) {
            output.add(new ArrayList<Integer>(curr)); //deep copy of curr
        }

        //add digit to curr list

        for (int i = digit; i < 9; i++) {
            curr.add(i + 1);
            backtrack(i + 1, total + i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}

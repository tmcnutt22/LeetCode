package Grokking.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0])); //lambda function

//        System.out.println(Arrays.deepToString(intervals)); //print 2d array

        LinkedList<int[]> output = new LinkedList<>();
        ArrayList<int[]> ALOutput = new ArrayList<>();

        for (int[] interval : intervals) {
            if (ALOutput.isEmpty() || interval[0] > ALOutput.get(ALOutput.size()-1)[1]) {
                ALOutput.add(interval);
            /*if (output.isEmpty() || interval[0] > output.getLast()[1]) {
                // if this is the first element or there is no overlap
                // append this to the LL
                output.add(interval);

             */
            } else {
                //there is overlap
                //output.getLast()[1] = Math.max(interval[1], output.getLast()[1]);

                ALOutput.get(ALOutput.size()-1)[1] = Math.max(interval[1], ALOutput.get(ALOutput.size()-1)[1]);
            }
        }
        //return output.toArray(new int[output.size()][]);
        return output.toArray(new int[ALOutput.size()][]);
    }
}
//O(nlogn) time when N is the number of intervals
//O(n) space where N is the number of intervals Linked List


/*
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
 */


/*

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

*/
package Grokking.MergeIntervals;

import Leetcode.LinkedList.LinkedListCycle;

import java.util.LinkedList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> retList = new LinkedList<>();
        int counter = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            //check if the interval is less than the first element, insert the interval first
            if (newInterval[1] < interval[0]) {
                retList.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    int[] tempInterval = intervals[j];
                    retList.add(tempInterval);
                }
                break;
                // if the new interval is after the current interval
            } else if (newInterval[0] > interval[1]) {
                retList.add(interval);
            } else { //else it overlaps, we can update the new interval to be the current overlapping interval and add it
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            counter++;
        }
        if (counter == intervals.length) {
            retList.add(newInterval); //if the new interval is the last item in the list. otherwise it returns early
        }
        return retList.toArray(new int[retList.size()][]);
    }
}

/*
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Input: intervals [[1,2], [5,7]], newInterval = [3,4]
 */
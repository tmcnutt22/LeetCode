package Grokking.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int result  = 0;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                prevEnd = Math.min(prevEnd, end);
                result++;
            }
        }
        return result;
    }
}

/*
O(nlogn) where n is the number of intervals
 */
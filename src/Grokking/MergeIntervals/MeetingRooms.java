package Grokking.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < prevEnd) {
                return false;
            } else {
                prevEnd = Math.max(prevEnd, end);
            }
        }
        return true;
    }
}

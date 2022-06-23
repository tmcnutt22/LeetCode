package Grokking.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        //sort the array
        int n = intervals.length;
        if (n == 0) return 0;
        int meetingRooms = 0;
        int count = 0;
        //create arrays and sort one for start and one for end
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0, endPointer = 0;

        while (startPointer < n) {
            if (start[startPointer] < end[endPointer]) {
                count++;
                startPointer++;
            } else {
                count--;
                endPointer++;
            }
            meetingRooms = Math.max(count, meetingRooms);
        }

        return meetingRooms;
    }
}


/*
UMPIRE

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Input: intervals = [[0, 30], [15, 25], [20, 60]] //3
Input: intervals = [[0, 30], [15, 25], [26, 60]] //2
Input: intervals = [[2,15],[36,45],[9,29],[16,23],[4,9]] -> sort [[2,15],[4,9],[9,29],[16,23],[36,45]]
[[2, 15], [4, 9], [9, 29], [16, 23], [36, 45]]

start :4
end :9
prevstart :2
prevend :15

start :16
end :23
prevstart :9
prevend :29

Understand:
is this an overlap? [0, 30], [30,60]?
empty array aka not meetings? 1?



Match:
sorting and a single iteration of the array.

Plan:


 */

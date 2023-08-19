package Leetcode.Intervals;

import java.util.ArrayList;

public class MyCalendar {
    private ArrayList<int[]> calendarList;

    public MyCalendar() {
        calendarList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (calendarList.size() == 0) {
            int[] temp = new int[2];
            temp[0] = start;
            temp[1] = end;
            calendarList.add(temp);
            return true;
        } else {
            int lastStart = calendarList.get(calendarList.size() - 1)[0];
            int lastEnd = calendarList.get(calendarList.size() - 1)[1];
            if (end >= lastEnd) {
                int[] temp = new int[2];
                temp[0] = start;
                temp[1] = end;
                calendarList.add(temp);
                return true;
            }
        }
        return false;
    }
}


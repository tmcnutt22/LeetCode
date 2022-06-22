package Grokking.MergeIntervals;

import java.util.LinkedList;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //if either 2d array is empty then there is no intersection, return empty
        if (firstList.length == 0 || secondList.length == 0) return new int[0][0];
        LinkedList<int[]> retList = new LinkedList<>(); //track the intersection as a ll of int[]s
        int firstIndex = 0;
        int secondIndex = 0; //these will point to the array that we are comparing

        int currMin, currMax;
        while (firstIndex < firstList.length && secondIndex < secondList.length) {
            //do something
            currMin = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            currMax = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);
            int[] tempArr = new int[] {currMin, currMax};
            if (currMin <= currMax) {
                retList.add(tempArr); //add to LL
            }
            if (firstList[firstIndex][1] < secondList[secondIndex][1]) { //if the interval from first list ends first
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        return retList.toArray(new int[retList.size()][]);
    }
}

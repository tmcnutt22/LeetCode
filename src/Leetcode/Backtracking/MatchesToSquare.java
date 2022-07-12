package Leetcode.Backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MatchesToSquare {
    public static void main(String[] args) {
        int[] matches = new int[] {1,3,67,4,3,5,5636,7243,277427,289};
        makesquare(matches);
    }

    public static boolean makesquare(int[] matchsticks) {
        int length = 0;

        for (int match : matchsticks) {
            length += match;
        }
        if (length % 4 != 0) {
            return false;
        }

        int sideLength = length / 4;


        //sort the matchsticks
        Arrays.sort(matchsticks);
        //reverse the sorted array so its descending
        for (int i = 0, j = matchsticks.length - 1; i < (matchsticks.length / 2); i++, j--) {
            int temp = matchsticks[j];
            matchsticks[j] = matchsticks[i];
            matchsticks[i] = temp;
        }
        return true;
    }
}

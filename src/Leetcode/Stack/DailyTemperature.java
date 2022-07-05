package Leetcode.Stack;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temps = new int[]{73, 74, 75, 71, 69, 72, 76, 73}; //[i, i ,4, 2, 1, 1, 0, 0]
        int[] temps2 = new int[]{30, 40, 50, 60};
        int[] retArr = dailyTemperatures(temps2);
        System.out.println(
                Arrays.toString(retArr));
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        //create a return array, values are defaulted to 0;
        int[] result = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] tempArr = stack.removeFirst();
                int lastTemp = tempArr[0];
                int index = tempArr[1];
                result[index] = i - index;
            }
            stack.addFirst(new int[]{temperatures[i], i});
        }

        return result;
    }
}

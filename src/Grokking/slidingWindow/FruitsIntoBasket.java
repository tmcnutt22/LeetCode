package Grokking.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        //int[] fruits = new int[] {1,2,1};
        //output: 3
        //int[] fruits = new int[] {0,1,2,2};
        //output: 3
        int[] fruits = new int[]{1, 2, 3, 2, 2};
        //output: 4
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        /*
        //variables
        int basketOneNumber = 0, basketTwoNumber = 0;
        int windowBeg = 0;
        int maxLength = Integer.MIN_VALUE;
        int windowLength = 0;

        for (int windowEnd = 0;
        }
        return maxLength;

         */
        int windowBeg = 0;
        int windowEnd = 0;
        int size = fruits.length;
        int windowSize = 2; // window size
        Map<Integer, Integer> map = new HashMap<>();
        int maxFruits = Integer.MIN_VALUE;
        int windowSum = 0;
        while (windowEnd < size) {
            map.put(fruits[windowEnd], map.getOrDefault(fruits[windowEnd], 0) + 1);
            windowSum++;
            if (map.size() <= windowSize) {
                maxFruits = Math.max(maxFruits, windowSum);
                windowEnd++;
            } else {
                while (map.size() > windowSize) {
                    if (map.containsKey(fruits[windowBeg])) {
                        if (map.get(fruits[windowBeg]) == 1) {
                            map.remove(fruits[windowBeg]);
                        } else {
                            map.put(fruits[windowBeg], map.get(fruits[windowBeg]) - 1);
                        }
                    }
                    windowBeg++;
                    windowSum--;
                }
                windowEnd++;
            }
        }
        return maxFruits;
        // O(n) time where n is the length of the array
        // O(n) space
    }
}

//UMPIRE
/*
Understand - This is basically a maximum contiguous subarray of size 2
Match - Sliding Window
Plan
Loop thorugh the array:
    go until you hit a third different number, then record the length as the max,
    then move the beginning window up, substract the beg array number count from
    the curr max increment the ending window until you hit a different number again and continue
    this until the array is iterated.

Implement
Review
Evaluate:
O(n) time | O(1) space
 */
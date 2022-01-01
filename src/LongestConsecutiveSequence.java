/*
Leetcode 128.
Longest Consecutive Sequence
Medium
runtime: O(n) -> while loop is not on order on of n^2
space: O(n) where net is the length of the array that is in the hashset


 */
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] intArray;
        intArray = new int[]{1, 2, 3, 4, 9, 10, 20};

        System.out.println(longestConsecutive(intArray));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            set.add(num);
        }

        int subSequenceLength = 0;
        for (int num : nums) {
            int currentLength = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    currentLength++;
                    num++;
                }
            }
            subSequenceLength = Math.max(subSequenceLength, currentLength);
        }
        return subSequenceLength;
    }
}

package Grokking.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctChars {
    public static void main(String[] args) {
        String s1 = "abcabcbb"; //3
        String s2 = "bbbbb"; //1
        String s3 = "pwwkew"; //3
        String s5 = "pwwkkk"; //2
        String s4 = "au";
        System.out.println(lengthOfLongestSubstring(s5));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int windowBeg = 0;
        int maxLen = Integer.MIN_VALUE;
        int windowLen = 0;
        Set<Character> set = new HashSet<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (!set.contains(s.charAt(windowEnd))) {
                set.add(s.charAt(windowEnd));
                windowLen++;
                maxLen = Math.max(maxLen, windowLen);
            } else {
                maxLen = Math.max(maxLen, windowEnd - windowBeg);
                windowEnd--;
                windowLen--; //decrement the windowlen everytime there is something removed from the set
                set.remove(s.charAt(windowBeg));
                windowBeg++;
            }
        }
        return maxLen;
    }


    /*
    UMPIRE

    What is the definition of a substring? contiguous array
    match: sliding window problem
    Plan:
    iterate the array:
        if char[end] not in set:
            add to set
            currSum++;
        else:
            set.remove(beg)
            beg++
        max = max(max, end - beg + 1)

     return max
     Implement: See above
     Review:
     Evalutae: O(n) time where n is the length of the string
     O(n) space
     */
}

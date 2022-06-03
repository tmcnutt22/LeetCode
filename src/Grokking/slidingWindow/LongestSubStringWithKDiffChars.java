package Grokking.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubStringWithKDiffChars {
    /*
    Given a string s and an integer k, return the length of the longest
    substring of s that contains at most k distinct characters.
     */
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        //Output: 3
        /*
        String s = "aa";
        int k = 1;
        //Output: 2

        String s = "ccaabbb";
        int k = 2;

         */

        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        /*
        if (k == 0) return 0;
        int result = 1;
        int windowStart = 0;
        HashSet<Character> set = new HashSet<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            //do something
            result = Math.max(result, windowEnd - windowStart + 1);
            System.out.println("For loop result " + result);
            set.add(s.charAt(windowEnd));
            System.out.println(set.toString());
            if (set.size() == k) {
                int tempIndex = windowEnd;
                while (tempIndex + 1 < s.length() && set.contains(s.charAt(tempIndex + 1))) {
                    result = Math.max(result, tempIndex + 1 - windowStart);
                    System.out.println("While loop result " + result);
                    System.out.println("Window beg " + windowStart);
                    System.out.println("Temp end " + tempIndex);
                    tempIndex++;

                }
                set.remove(s.charAt(windowStart));
                windowStart++;
            }
        }

        return result;

         */
        if (s == null || s.length() == 0)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = s.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}

    /*
    match
    sliding window using a hashset.
     */

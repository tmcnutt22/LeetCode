package Grokking.slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoChars {
    public static void main(String[] args) {
        String s1 = "eceba"; //3 ece
        String s2 = "ccaabbb"; //5 aabbb
        String s3 = " ";
        System.out.println(s3.length());
        System.out.println(lengthOfLongestSubstringTwoDistinct(s2));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int windowBeg = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            //condition that the size is at most 2
            if (!map.containsKey(currChar) && map.size() < 2) {
                map.put(currChar, 1);
                maxCount = Math.max(maxCount, windowEnd - windowBeg + 1);
            } else if(map.containsKey(currChar) && map.size() <= 2) {
                map.put(currChar, map.get(currChar) + 1);
                maxCount = Math.max(maxCount, windowEnd - windowBeg + 1);
            } else { //
                windowEnd--;
                while(map.size() > 1 && map.containsKey(s.charAt(windowBeg))) {
                    char begChar = s.charAt(windowBeg);
                    if (map.get(begChar) > 1) {
                        map.put(begChar, map.get(begChar) - 1);
                    } else {
                        map.remove(begChar);
                    }
                    windowBeg++;
                }
            }
        }
        return maxCount;
    }
}

/*
UMPIRE
Understand:
- emtpy string?
- valid input?
- time and space constraints
-
Match:
sliding window -> constant memory (could be tricky)
Slding window with a hashmap (char is the key: count is value) got until it doesn't contain
record the max length using the indices

plan:

implement:

review: edge cases?

Evaluate: O(n) time | O(n) space

 */
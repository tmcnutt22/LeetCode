package Grokking.slidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        String s1 = "AABABBA";
        int k1 = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String str, int k) {
        // Hashmap that stores the char and its frequency
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        // the maximum count of the most frequency characters for all time
        int maxRepeatCount = 0;
        // the left index of the sliding window
        int windowBeg = 0;
        // the maximum length that we will be looking for
        int maxLen = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            // get the current Character
            char currChar = str.charAt(windowEnd);
            // put the curr character into the map, increment by 1 if it has already been stored in the map
            charFrequencyMap.put(currChar, charFrequencyMap.getOrDefault(currChar, 0) + 1);
            // check if the current character repeats more than the current max count.
            maxRepeatCount = Math.max(maxRepeatCount, charFrequencyMap.get(currChar));
            // get the current length of the window, for example, for window [A, A, A, B, C],
            // the StartIndex is 0, windowEnd is 4, and the length is 4 - 0 + 1 = 5;
            int currLen = windowEnd - windowBeg + 1;

            // check if the current window size minus the maximum repeat count is already greater than the max number
            // of characters that we can replace, if it is then we should shrink the window size from the windowBeg.
            if (currLen - maxRepeatCount > k) {
                currChar = str.charAt(windowBeg);
                charFrequencyMap.put(currChar, charFrequencyMap.get(currChar) - 1);
                windowBeg++;
            }

            // check whether the current window size is greater than the max length
            maxLen = Math.max(maxLen, windowEnd - windowBeg + 1);
        }
        // return the max length with repeating characters after the k replacements
        return maxLen;
    }
}


/*
UMPIRE
Understand:
Match: Sliding window
Plan:
iterate the string until there are k number of items in a hash (set or map?)
record the len
pop off the beginning, decrement curr len and window end

return count;
Implement:
Review:
Evalutate:
O(n) time and space
 */

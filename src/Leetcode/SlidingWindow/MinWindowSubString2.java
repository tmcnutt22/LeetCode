package Leetcode.SlidingWindow;
import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString2 {
    /*
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        //if (n > m) return "";

        int lenSubStr = Integer.MAX_VALUE;
        //left idx 0 right index 1
        int[] indices = new int[]{-1, -1};

        //charFreq for t
        HashMap<Character, Integer> charFreqT = new HashMap<>();
        for (char c: t.toCharArray()) {
            charFreqT.put(c, charFreqT.getOrDefault(c, 0) + 1);
        }

        //HashMap for the sliding window sliding
        HashMap<Character, Integer> charFreqS = new HashMap<>();

        //ints for tracking conditions
        int sizeT = charFreqT.size();
        int sizeS = 0;

        int left = 0;
        for (int right = 0; right < m; right++) {
            char cS = s.charAt(right);
            charFreqS.put(cS, charFreqS.getOrDefault(cS, 0) + 1);
            if (charFreqT.containsKey(cS) && charFreqS.get(cS) == charFreqT.get(cS)) {
                sizeS++;
                while (left <= right && sizeS == sizeT) {
                    if ((right - left + 1) < lenSubStr) {
                        lenSubStr = right - left + 1;
                        indices[0] = left;
                        indices[1] = right;
                    }
                    //move left pointer
                    char cT = s.charAt(left);
                    charFreqS.put(cT, charFreqS.get(cT) - 1);
                    if (charFreqT.containsKey(cT) && charFreqS.get(cT).intValue() < charFreqT.get(cT).intValue()) {
                        sizeS--;
                    }
                    left++;
                }
            } //else move to next char
        }
        if (lenSubStr < Integer.MAX_VALUE) {
            return s.substring(indices[0], indices[1] + 1);
        } else {
            return "";
        }
    }
}
*/
    class Solution {
        public String minWindow(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            // Dictionary which keeps a count of all the unique characters in t.
            HashMap<Character, Integer> dictT = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
            }

            // Number of unique characters in t, which need to be present in the desired window.
            int required = dictT.size();

            // Left and Right pointer
            int l = 0, r = 0;

            // formed is used to keep track of how many unique characters in t
            // are present in the current window in its desired frequency.
            // e.g. if t is "AABC" then the window must have two A's, one B and one C.
            // Thus formed would be = 3 when all these conditions are met.
            int formed = 0;

            // Dictionary which keeps a count of all the unique characters in the current window.
            Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

            // ans list of the form (window length, left, right)
            int[] ans = { -1, 0, 0 };

            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and contract the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    // Save the smallest window until now.
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    // The character at the position pointed by the
                    // `Left` pointer is no longer a part of the window.
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                        formed--;
                    }

                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }

                // Keep expanding the window once we are done contracting.
                r++;
            }

            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        }
    }
}

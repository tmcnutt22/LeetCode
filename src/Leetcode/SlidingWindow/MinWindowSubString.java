package Leetcode.SlidingWindow;
import java.util.HashMap;

public class MinWindowSubString {
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
                while (sizeS == sizeT) {
                    if ((right - left + 1) < lenSubStr) {
                        lenSubStr = right - left + 1;
                        indices[0] = left;
                        indices[1] = right;
                    }
                    //move left pointer
                    char cT = s.charAt(left);
                    charFreqS.put(cT, charFreqS.get(cT) - 1);
                    if (charFreqT.containsKey(cT) && charFreqS.get(cT) < charFreqT.get(cT)) {
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

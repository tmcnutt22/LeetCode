package Leetcode.SlidingWindow;

public class CharacterReplacement {
    public static void main(String[] args) {
        String s = "ABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];
        int len = s.length();
        int longest = 0;

        int left = 0;
        for (int right = 0; right < len; right++) {
            charFreq[s.charAt(right) - 'A']++;
            int mostFreq = getMostFrequent(charFreq);
            int windowSize = right - left + 1;

            if (windowSize - mostFreq <= k) {
                longest = Math.max(longest, windowSize);
            } else {
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return longest;
    }

    public static int getMostFrequent(int[] charFreq) {
        int mostFreq = 0;
        for (int i : charFreq) {
            mostFreq = Math.max(mostFreq, i);
        }
        return mostFreq;
    }

}

package Grokking.slidingWindow;

import java.util.HashMap;

public class PermutationInString {
    public static void main(String[] args) {
        String s11 = "abb";
        String s21 = "eidba000";
        String s12 = "ab";
        String s22 = "eidboaoo";
        checkInclusion(s11, s21);
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        //create hashmap of s1
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            char currChar = s1.charAt(i);
            charFrequency.put(currChar, charFrequency.getOrDefault(currChar,0) + 1);
        }

        System.out.println(charFrequency.keySet());
        System.out.println(charFrequency.values());
        return false;
    }
}
/*
UMPIRE
Understand
- will s1 have only unique chars? if yes we can use a set maybe?
- subarray means contiguous?

Match
- hash (either set or map) go with map to be safe. count the occurences of the chars in s1, that's the value

plan
- create a hashmap of chars in s1 with their frequency

- loop through s2 until you hit a char that's in the map
    - make this the left pointer
    - create a deep copy of the map?
    - iterate the string until either the map is empty return true
    -   else a char that isn't in the map
    -     move the left pointer to the char that there is another char in the map?


 */

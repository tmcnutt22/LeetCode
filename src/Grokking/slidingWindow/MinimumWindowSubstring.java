package Grokking.slidingWindow;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC"; //BANC
        String s2 = "a";
        String t2 = "a"; //""
        String s3 = "a";
        String t3 = "aa"; //""
        System.out.println(minWindow(s1,t1));
    }

    public static String minWindow(String s, String t) {
        Set<Character> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        createSet(t, set);

        int left = 0;
        int currRight = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            //iterate until a char in the substring occurs
            if (!set.contains(currChar)) {
                continue;
            }
            //once a char substring is found
            int counter = right;
            left = right;
            while (!set.isEmpty() && counter < s.length()) {
                char tempChar = s.charAt(currChar);
                set.remove(tempChar);
                counter++;
            }
            currRight = counter;
            if (set.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(counter);
                map.put(counter - left + 1, list);
                createSet(t, set);
            } else {
                return "";
            }
        }
        int min = Integer.MAX_VALUE;
        for (int key: map.keySet()) {
            if (key < min) {
                min = key;
            }
        }
        List<Integer> tempList = map.get(min);
        StringBuilder sb = new StringBuilder();
        for (int i = tempList.get(0); i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void createSet(String t, Set<Character> set) {
        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            set.add(currChar);
        }
    }
}
/*
UMPIRE

Understand;
- alpha numeric?
- empty string?
- space and time constraints

Match:
- sliding window
-
 */
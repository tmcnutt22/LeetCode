package Leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class strStr {
    public static void main(String[] args) {
        String haystack = "\"\"";
        String needle = "\"\"";
        System.out.println(strStr(haystack, needle));

        String haystack2 = "\"\"";
        String needle2 = "\"\"";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        Queue<Character> queue = new LinkedList<Character>();
        int firstIndex = -1;
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < needle.length(); i++) { //creates a queue and adds the needle characters to it
            queue.add(needle.charAt(i));
        }

        
        //iterate the haystack
        int j = 0;
        for (j = 0; j  < haystack.length(); j++) {
            if (haystack.charAt(j) == queue.peek()) {
                firstIndex = j;
                queue.remove();
                break;
            }
        }

        for (int k = j + 1; k < haystack.length(); k++) {
            if (queue.isEmpty()) {
                return 0;
            } else if (haystack.charAt(k) != queue.peek()) {
                return -1;
            } else {
                queue.remove();
            }

            if (queue.isEmpty()) return firstIndex;
        }
        return firstIndex;
    }
}

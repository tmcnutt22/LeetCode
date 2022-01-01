import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String input = "bbbb";
        /*
        System.out.println(input.charAt(0) != input.charAt(1));
        Set<Character> set = new HashSet<Character>();
        set.add(input.charAt(0));
        System.out.println(set.contains(input.charAt(2)));
         */
        System.out.println(lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0; //empty string
        int longestSubstring = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                Set<Character> set = new HashSet<>();
                set.add(s.charAt(i));
                set.add(s.charAt(i + 1));
                int currentStreak = 2;
                int tempPtr = i+1;
                while (tempPtr + 1 < s.length() &&
                        s.charAt(tempPtr) != s.charAt(tempPtr + 1) &&
                        !set.contains(s.charAt(tempPtr + 1))) {
                    set.add(s.charAt(tempPtr + 1));
                    currentStreak++;
                    tempPtr++;
                }
                longestSubstring = Math.max(currentStreak, longestSubstring);
            }
        }
        return longestSubstring;
    }
}

/*
1. emtpy strings?
2. all chars?
3. memory / time constraints?

'memory' -> 5 (emory)
'memo' -> 3 (emo)
'abcde' -> 5 (abcde)

match -> hash

plan:

ITERATIVE APPROACH
index
longestSubstring = 1
Set

for (0; <= s.length -1; ++)
    if (charAt(i) != charAt(i+1)
        set.add(charAt curr, curr+1) do i need to empty this each loop?
        currentStreak int = 2;
        tempPointer = index+1
        while loop (temp != temp+1 && temp+1 <= s.length && !set.contains(temp+1)
            set.add(s(temp+1)
            currentStreak++
            temp++
        compare longestSubstring and currentStreak replace if curr is bigger

when completed return longestSubstring
O(n) time
O(1) memory



 */
/*public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

 */
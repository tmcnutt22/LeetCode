package Leetcode.DP.Memoization;

import java.util.HashMap;

public class CanConstructMemo {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee","eeeeeee"}, new HashMap<>()));
    }

    public static boolean canConstruct(String target, String[] wordBank, HashMap<String, Boolean> map) {
        System.out.println(target);
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target.equals("")) {
            return true;
        }
        for (String word: wordBank) {
            if (target.startsWith(word)) {
                String targetSubStr = target.substring(word.length());
                if (canConstruct(targetSubStr, wordBank, map)) {
                    //returning early so no point in memoizing
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }
}

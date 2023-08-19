package Leetcode.DP.Memoization;

import java.util.HashMap;

public class CanConstructRecursive {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee","eeeeeee"}));
    }
    public static boolean canConstruct(String target, String[] wordBank) {
        System.out.println(target);
        if (target.equals("")) {
            return true;
        }
        for (String word: wordBank) {
            if (target.startsWith(word)) {
                String targetSubStr = target.substring(word.length());
                if (canConstruct(targetSubStr, wordBank)) {
                    return true;
                }
            }
        }
        return false;
    }
}

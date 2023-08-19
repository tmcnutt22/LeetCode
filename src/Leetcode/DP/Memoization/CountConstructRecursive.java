package Leetcode.DP.Memoization;

public class CountConstructRecursive {
    public static void main (String[] args) {
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee","eeeeeee"}));

    }
    public static int countConstruct(String target, String[] wordBank) {
        if (target.equals("")) return 1;
        int totalCount = 0;
        for (String word: wordBank) {
            if (target.startsWith(word)) {
                String subStr = target.substring(word.length());
                totalCount += countConstruct(subStr, wordBank);
            }
        }
        return totalCount;
    }
}

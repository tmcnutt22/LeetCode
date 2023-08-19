package Leetcode.DP.Tabulation;

public class CanConstructTab {
    public static boolean canConstruct(String target, String[] wordBank) {
        boolean[] dp = new boolean[target.length() + 1];
        dp[0] = true;

        for (int i = 0; i <= target.length(); i++) {
            if (dp[i]) {
                String targetSubStr = target.substring(i);
                //System.out.println("Substr: " + targetSubStr);
                for (String word: wordBank) {
                    if (targetSubStr.startsWith(word)) {
                        dp[word.length() + i] = true;
                    }
                }
            }
        }
        for (boolean bool: dp) {
            System.out.print(bool + "|");
        }
        System.out.println();

        return dp[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeeee"}));
    }

}

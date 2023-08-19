package Leetcode.DP.Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstructRecursive {

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return allConstructHelper(target, wordBank, 0, memo);
    }

    private static List<List<String>> allConstructHelper(String target, String[] wordBank, int startIndex, Map<Integer, List<List<String>>> memo) {
        if (memo.containsKey(startIndex)) {
            return memo.get(startIndex);
        }

        if (startIndex == target.length()) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<String>> allWays = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word, startIndex)) {
                List<List<String>> partialWays = allConstructHelper(target, wordBank, startIndex + word.length(), memo);
                for (List<String> way : partialWays) {
                    List<String> newWay = new ArrayList<>(way);
                    newWay.add(word);
                    allWays.add(newWay);
                }
            }
        }

        memo.put(startIndex, allWays);
        return allWays;
    }

    public static void main(String[] args) {
        String target = "abcdef";
        String[] wordBank = { "ab", "abc", "cd", "def", "abcd", "ef", "c" };

        List<List<String>> result = allConstruct(target, wordBank);

        for (List<String> way : result) {
            System.out.println(way);
        }
    }
}

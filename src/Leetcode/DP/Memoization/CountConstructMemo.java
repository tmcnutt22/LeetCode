package Leetcode.DP.Memoization;
import java.util.HashMap;

public class CountConstructMemo {
    public static void main(String [] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()));
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
                                              new String[]{"e", "ee", "eee", "eeee", "eeeee","eeeeeee"}, new HashMap<>()));
        long endTime = System.currentTimeMillis();
        System.out.println("Time to complete: " + (endTime - startTime));

}
    public static long countConstruct(String target, String[] wordBank, HashMap<String, Long> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target.equals("")) return 1;
        long totalCount = 0;
        for (String word: wordBank) {
            if (target.startsWith(word)) {
                String subStr = target.substring(word.length());
                totalCount += countConstruct(subStr, wordBank, map);
                //map.put(target, totalCount);
            }
        }
        map.put(target, totalCount);
        return totalCount;
    }
}

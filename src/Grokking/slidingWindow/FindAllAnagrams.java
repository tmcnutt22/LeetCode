package Grokking.slidingWindow;

import java.util.HashMap;

public class FindAllAnagrams {
    public static void main(String[] args) {
        HashMap <Character, Integer> map1 = new HashMap<>();
        HashMap <Character, Integer> map2 = new HashMap<>();
        map1.put('a', 2);
        map1.put('b', 3);
        map2.put('a', 2);
        map2.put('b', 2);
        System.out.println(map1.equals(map2));
        System.out.println(map1.values());
        System.out.println(map2.values());
    }
}

package Leetcode.DP.Memoization;

import java.util.HashMap;

public class GridTravelerMemo {
    public static void main(String[] args) {

        System.out.println(gridTraveler(1, 1, new HashMap<>())); //1
        System.out.println(gridTraveler(2, 3, new HashMap<>())); //3
        System.out.println(gridTraveler(3, 2, new HashMap<>())); //3
        System.out.println(gridTraveler(3, 3, new HashMap<>())); //6
        System.out.println(gridTraveler(18, 18, new HashMap<>())); //
    }

    public static long gridTraveler(int m, int n, HashMap<String, Long> map) {
        String key = createKey(m, n);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (m == 1 && n == 1) {
            String keyTemp = createKey(m, n);
            map.put(key, 1L);
            return 1;
        }

        if (m <= 0 || n <= 0) {
            String keyTemp = createKey(m, n);
            map.put(key, 0L);
            return 0;
        }

        long travel = gridTraveler(m - 1, n, map) + gridTraveler(m, n - 1, map);

        map.put(key, travel);
        return travel;
    }

    public static String createKey(int m, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(m);
        sb.append('+');
        sb.append(n);
        return sb.toString();
    }

}

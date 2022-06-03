package Leetcode;

import java.util.HashMap;

public class NumOfGoodPairs {
    public static void main(String[] args) {
    int[] nums = new int[] {1,2,3,1,1,3};
    System.out.println(numIdenticalPairs(nums));
    }
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //iterate the array and add the number of occurences to the hashmap.
        for (int num : nums) {
            if (map.containsKey(num)) {
                //do something
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int count = 0;
        //do some math to figure out the number of pairs that exists
        //n*(n-1) / 2 will give the number of pairs for each key in the hash map.
        for(Integer key: map.keySet()) {
            int value = (map.get(key) * (map.get(key) - 1))/2;
            count += value;
        }

        return count;

    }
}

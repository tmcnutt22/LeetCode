package Leetcode;

import java.util.HashMap;

public class MajorityFrequency {
    public static void main( String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqList = new HashMap<Integer, Integer>();
        int max = 0;
        for(int num: nums){
            if(!freqList.containsKey(num)){
                freqList.put(num, 1);
            }else{
                freqList.put(num, freqList.get(num)+1);
            }
        }

        for(int key: freqList.keySet()){
            if(freqList.get(key) > max){
                max = key;
            }
        }
        return max;
    }
}

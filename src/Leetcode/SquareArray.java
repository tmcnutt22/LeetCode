package Leetcode;

public class SquareArray {
    public static void main(String[] args) {
        int[] nums1 = {-4,-1,0,3,10};
        int[] nums2 = {-11,-1,0,3,10};
        int[] nums3 = {-7,-3,2,3,11};


    }

    public static int[] squareArray(int[] nums) {
        int len = nums.length -1;
        int[] retArray = new int[len + 1];
        int end = len;
        int begin = 0;

        for (int newArrIndex = len; newArrIndex >= 0; newArrIndex--) {
            if(Math.abs(nums[begin]) > Math.abs(nums[end])) {
                retArray[newArrIndex] = (int)(Math.pow(nums[begin], 2));
                begin++;
            } else {
                retArray[newArrIndex] = (int)(Math.pow(nums[end], 2));
                end--;
            }
        }
        return retArray;
    }
}


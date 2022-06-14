package Leetcode;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        System.out.println(isMonotonic(nums));
    }
    public static boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) return true;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > num) {
                //System.out.println(" check here " + num);
                int counter = i;
                while (counter < nums.length) {
                    if (nums[counter] < num) {
                        //System.out.println("happened here");
                        return false;
                    }
                    num = nums[counter];
                    counter++;
                }
                return true;
            } else if (nums[i] < num) {
                //System.out.println(num);
                int counter = i;
                while (counter < nums.length) {
                    if (nums[counter] > num) {
                        //System.out.println("how?");
                        return false;
                    }
                    num = nums[counter];
                    counter++;
                }
                return true;
            } else {
                num = nums[i];
            }
        }
        return true;
    }
}

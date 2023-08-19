package Leetcode.BinarySearch;

public class SuccessfulPairsOfSpellsAndPotions {
    //binary search helper, returns the last index where spell * potion < success
    public static int binarySearch(int spell, int[] potions, long success, int left, int right) {
        int loopCounter = 0;
        while (left <= right && loopCounter < potions.length) {
            loopCounter++;
            int pivot = (left + right) / 2;
            //System.out.println("Pivot: " + pivot);
            long currStrength = (long) spell * potions[pivot];
            //System.out.println(currStrength);

            if (currStrength >= success) {
                right = pivot;
            } else {
                left = pivot;
            }
        }
        if (left == 0) {
            return potions.length;
        }
        return potions.length - left - 1;
    }
    public static void main(String[] args) {
        int[] spells = {15, 8, 19};
        int[] potions = {38, 36, 23};
        long success = 328;
        int[] retArray = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            retArray[i] = binarySearch(spells[i], potions, success, 0, potions.length);
        }

        for (int i: retArray) {
            System.out.println(i);
        }
    }
}

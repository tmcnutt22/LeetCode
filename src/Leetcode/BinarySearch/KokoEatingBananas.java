package Leetcode.BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 6, 7, 11};
        int h1 = 8;
        int[] arr2 = new int[]{30, 11, 23, 4, 20};
        int h2 = 5;
        int[] arr3 = new int[]{30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(minEatingSpeed(arr3, h3));

    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1; //lowest k possible
        int high = 0; //highest k possible
        for (int pile : piles) {
            high = Math.max(pile, high);
        }// set high to the largest amount in the array O(n)

        int bananasPerHour = high; //best possible case
        System.out.println("BPH: " + bananasPerHour);
        //binary search
        while (low <= high) { // while low bph <= high bph
            int k = (low + high) / 2; //k being the middle bph  in the range
            System.out.println(k);
            int hours = 0; //counts the number of hours it takes koko to eat the piles
            for (int pile : piles) { //iterates the piles
                //records how many hours it takes to eat each pile
                System.out.println("pile size: " + pile);
                hours += Math.ceil((float) pile / k); //rounds up if > bananas > bph aka k
                System.out.println("Running hours :" + hours);
            }
            System.out.println("Hours: " + hours);
            //records the min for all instances where hours <= h even if its below h
            if (hours <= h) { //eating fast enoough or too fast
                bananasPerHour = Math.min(k, bananasPerHour);
                System.out.println("BPH Updated :" + bananasPerHour);
                high = k - 1;
            } else { //eating too slow
                low = k + 1;
            }
        }
        return bananasPerHour;
    }
}
/*
UMPIRE

Understand
Match
- binary search

Plan:

Implement
Review
Evaluate

O(max k log(k)) where k is the fastest eating speed
 */

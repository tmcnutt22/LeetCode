package Grokking.fastandslow;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(isHappy(i));
    }

    public static boolean isHappy(int n) {
        //use a set. do the math, add it to the set, if it's in the set return false
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            // do something
            n = sumOfSquares(n);
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }

    public static int sumOfSquares(int n) {
        int currInt = n;
        int retInt = 0;
        while (currInt > 0) {
            retInt += (currInt % 10) * (currInt % 10);
            currInt /= 10;
        }
        return retInt;
    }
}

/*
n = 19 -> true

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + )^2 + 0^2 = 1 -> happy

//each number %10, squre it, add it then //10 until the number is 0. add sum to list node
go until either a the sum == 1 or until a cycle is detected.

 */

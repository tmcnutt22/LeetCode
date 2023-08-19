package Leetcode.DP.Memoization;

public class GridTravelerRecursive {
    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1)); //1
        System.out.println(gridTraveler(2, 3)); //3
        System.out.println(gridTraveler(3, 2)); //3
        System.out.println(gridTraveler(3, 3)); //6
        System.out.println(gridTraveler(18, 18)); //
    }

    public static int gridTraveler(int m, int n) {
        //System.out.println("m: "+ m + " n: " + n);
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 0 || n == 0) {
            return 0;
        }

        return gridTraveler(m, n - 1) + gridTraveler(m - 1, n);
    }
}

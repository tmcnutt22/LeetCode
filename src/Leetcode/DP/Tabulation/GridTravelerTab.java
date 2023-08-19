package Leetcode.DP.Tabulation;

public class GridTravelerTab {
    public static void main(String[] args) {
        System.out.println(gridTraveler(3, 3));
        System.out.println(gridTraveler(18, 18));
    }

    public static long gridTraveler(int m, int n) {
        long[][] grid = new long[m + 1][n + 1];
        grid[1][1] = 1L;

        for (int row = 0; row < m + 1; row++) {
            for (int col = 0; col < n + 1; col++) {
                if (col + 1 < n + 1) {
                    grid[row][col + 1] += grid[row][col];
                }

                if (row + 1 < m + 1) {
                    grid[row + 1][col] += grid[row][col];
                }

            }
        }
        return grid[m][n];
    }

}

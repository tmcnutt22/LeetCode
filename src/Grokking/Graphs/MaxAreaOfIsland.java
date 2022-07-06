package Grokking.Graphs;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid1 = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}; //6
        System.out.println(maxAreaOfIsland(grid1));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null || grid.length == 0) return maxArea;

        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(bfs(grid, row, col, numRows, numCols), maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int bfs(int[][] grid, int row, int col, int numRows, int numCols) {
        if (row < 0 || col < 0 || row >= numRows || col >= numCols || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return (1 +
                bfs(grid, row + 1, col, numRows, numCols) +
                bfs(grid, row - 1, col, numRows, numCols) +
                bfs(grid, row, col + 1, numRows, numCols) +
                bfs(grid, row, col - 1, numRows, numCols));
    }
}

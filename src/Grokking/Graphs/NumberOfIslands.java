package Grokking.Graphs;

import java.util.Arrays;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid1 = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}; //3

        numIslands(grid1);

    }

    public static int numIslands(char[][] grid) {
        int numOfIslands = 0;
        if (grid == null || grid.length == 0) return numOfIslands;

        int numOfRows = grid.length;
        int numOfColumns = grid[0].length;

        for (int row = 0; row < numOfRows; row++) {
            for (int col = 0; col < numOfColumns; col++) {
                if (grid[row][col] == '1') {
                    //call dfs each time the traversal hits a '1'
                    bfs(grid, row, col, numOfRows, numOfColumns);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    public static void bfs(char[][] grid, int currRow, int currCol, int numRows, int numCols) {
        // checks to make sure in bounds of grid and not visited
        if (currRow < 0 || currCol < 0 || currRow >= numRows || currCol >= numCols || grid[currRow][currCol] == '0') {
            return;
        }
        grid[currRow][currCol] = '0'; //marks as visited
        //call bfs on curr neighbors
        bfs(grid, currRow - 1, currCol, numRows, numCols); // left
        bfs(grid, currRow + 1, currCol, numRows, numCols); // right
        bfs(grid, currRow, currCol - 1, numRows, numCols); // above
        bfs(grid, currRow, currCol + 1, numRows, numCols); // below
    }
}

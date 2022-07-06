package Grokking.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(grid));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int numRows = heights.length;
        int numCols = heights[0].length;
        boolean[][] pacPossible = new boolean[numRows][numCols];
        boolean[][] atlPossible = new boolean[numRows][numCols];

        //iterate from ocean to middle
        //from top / bottom rows iterating left to right
        for (int col = 0; col < numCols; col++) {
            dfs(heights, pacPossible, 0, col, heights[0][col]); // top row pacifc
            dfs(heights, atlPossible, numRows - 1, col, heights[numRows - 1][col]); // bottom row atlantic
        }

        for (int row = 0; row < numRows; row++) {
            dfs(heights, pacPossible, row, 0, heights[row][0]); //pacfic, first column
            dfs(heights, atlPossible, row, numCols - 1, heights[row][numCols - 1]); //atl, last column
        }


        //traverse the graph and if each location is in each set, add it to the ret list
        List<List<Integer>> retList = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (pacPossible[row][col] && atlPossible[row][col]) {
                    retList.add(List.of(row, col));
                }
            }
        }
        return retList;
    }

    public static void dfs(int[][] heights, boolean[][] isVisited, int row, int col, int prevHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length ||
                isVisited[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        isVisited[row][col] = true;
        dfs(heights, isVisited, row - 1, col, heights[row][col]);
        dfs(heights, isVisited, row + 1, col, heights[row][col]);
        dfs(heights, isVisited, row, col - 1, heights[row][col]);
        dfs(heights, isVisited, row, col + 1, heights[row][col]);
    }

}

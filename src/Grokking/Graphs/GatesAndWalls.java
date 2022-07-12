package Grokking.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GatesAndWalls {

    public static void main(String[] args) {
        int[][] rooms = {{2147483647, -1, 0, 2147483647},
                         {2147483647, 2147483647, 2147483647, -1},
                         {2147483647, -1, 2147483647, -1},
                         {0, -1, 2147483647, 2147483647}};
        System.out.println(Arrays.deepToString(rooms));
        wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public static void wallsAndGates(int[][] rooms) {
        int numRows = rooms.length;
        int numCols = rooms[0].length;
        boolean[][] isVisited = new boolean[numRows][numCols];

        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (rooms[row][col] == 0) {
                    q.add(new int[]{row, col});
                    isVisited[row][col] = true;
                }
            }
        }

        int distance = 0;
        while (!q.isEmpty()) {
            int qLen = q.size();
            System.out.println(qLen);
            for (int i = 0; i < qLen; i++) {
                int[] temp = q.poll();
                assert temp != null;
                int r = temp[0];
                int c = temp[1];
                rooms[r][c] = distance;
                addRoom(rooms, q, isVisited, r + 1, c, numRows, numCols);
                addRoom(rooms, q, isVisited, r - 1, c, numRows, numCols);
                addRoom(rooms, q, isVisited, r, c + 1, numRows, numCols);
                addRoom(rooms, q, isVisited, r, c - 1, numRows, numCols);
            }
            distance++;
        }
    }

    public static void addRoom(int[][] rooms, Queue<int[]> queue, boolean[][] isVisited, int row, int col, int numRows, int numCols) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || rooms[row][col] == -1 || isVisited[row][col]) {
            return;
        }
        isVisited[row][col] = true;
        queue.add(new int[]{row, col});
    }
}

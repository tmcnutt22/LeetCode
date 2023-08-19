package Grokking.Graphs;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4}}; // false
        int n2 = 5;
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3},{1,4}}; //false

        int n3 = 4;
        int [][] edges3 = new int[][]{{2,3},{1,2},{1,3}};
        System.out.println(validTree(n, edges));
        System.out.println(validTree(n2, edges2));
        System.out.println(validTree(n3, edges3));
    }

    public static boolean validTree(int n, int[][] edges) {
        //edge case
        if (edges.length != n - 1) {
            return false;
        }

        //create needed data structures
        //HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        List<List<Integer>> adjList = new ArrayList<>();
        HashSet<Integer> seenSet = new HashSet<>();

        //add values to the adjacnecy matrix
        // Make the adjacency list.
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            //1 way
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);

            //the other
        }

        //run DFS
        DFS(0, adjList, seenSet);
        seenSet.add(0);

        return seenSet.size() == n;
    }

    public static void DFS(int val, List<List<Integer>> adjList, HashSet<Integer> seenSet) {
        if (seenSet.contains(val)) return;

        seenSet.add(val);
        for (Integer num : adjList.get(val)) {
            DFS(num, adjList, seenSet);
        }
    }
}

package Grokking.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prereqs = new int[][]{{1, 0}, {0, 1}};
        int numCourses = 2; //false

        int[][] prereqs2 = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses2 = 4; //true

        int[][] prereqs3 = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {2, 3}};
        int numCourses3 = 4; //false

        int[][] prereqs4 = new int[][]{{0, 1}};
        int numCourses4 = 2; //true
        System.out.println(canFinish(numCourses, prereqs));
        System.out.println(canFinish(numCourses2, prereqs2));
        System.out.println(canFinish(numCourses3, prereqs3));
        System.out.println(canFinish(numCourses4, prereqs4));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] inDegree = new int[numCourses];
        //int[] topoSort = new int[numCourses];

        //fills out the adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int post = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(preReq, new LinkedList<Integer>());
            list.add(post);
            adjList.put(preReq, list);
            inDegree[post] += 1;
        }

        //add all courses without a prereq into a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //while queue is not empty, perform topo sort
        int index = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            //topoSort[index++] = currCourse;
            index++;

            if (adjList.containsKey(currCourse)) {
                for (Integer course: adjList.get(currCourse)){
                    inDegree[course] -= 1;
                    if (inDegree[course] == 0) {
                        queue.add(course);
                    }
                }
            }
        }
        return index == numCourses;
    }
}


package Grokking.Graphs;


import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] topologicalResult = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(topologicalResult));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //create an adjacency list
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        //fill the adj list
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(preReq, new LinkedList<Integer>());
            list.add(course);
            adjList.put(preReq, list);
            inDegree[course] += 1; // counts the prereqs for each course
        }

        //create a q starting with the course with no prereqs
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }


        //while the queue is not empty, run DFS
        int index = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.removeFirst();
            topologicalOrder[index++] = currCourse;

            //check to see if the current course is prereq of others, if so basically remove it
            // by decrementing all dependencies by 1
            if (adjList.containsKey(currCourse)) {
                for (Integer dependency: adjList.get(currCourse)) {
                    inDegree[dependency] -= 1;
                    if (inDegree[dependency] == 0) {
                        queue.addLast(dependency);
                    }
                }
            }
        }
        if (index != numCourses) {
            return new int[]{};
        }
        return topologicalOrder;
    }
}

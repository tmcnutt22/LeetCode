package Leetcode.HashTable;

import java.util.HashMap;
import java.util.List;

public class BrickWall {
    public static void main(String[] args) {

    }

    public int leastBricks(List<List<Integer>> wall) {
        //System.out.println(wall.size()); //height
        //System.out.println(wall.get(0).size()); //width
        HashMap<Integer, Integer> map = new HashMap<>();
        int wallHeight = 0;
        //for (List<Integer> row: wall) { //for each loop works as well but wanted to iterate the list
        for (int j = 0; j < wall.size(); j++)  {
            int currLength = 0;
            for (int i = 0; i < wall.get(j).size() - 1; i++) {

                currLength += wall.get(j).get(i);
                //System.out.println(currLength);
                map.put(currLength, map.getOrDefault(currLength, 0) + 1);
            }
            wallHeight += 1;
        }

        //calculate the number of edges that occur the most

        int maxEdges = 0;

        for (int key: map.keySet()) {
            maxEdges = Math.max(maxEdges, map.get(key));

        }

        return wall.size() - maxEdges;
    }
}

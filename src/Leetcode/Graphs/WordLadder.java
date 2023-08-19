package Leetcode.Graphs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length(); //all words are the same length
        if (!wordList.contains(endWord)) return 0;
        HashMap<String, List<String>> neighbors = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                //generates all the possible intermediate words
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = neighbors.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                neighbors.put(newWord, transformations);
            }
        }
        int pathLength = 1;
        Deque<String> queue = new ArrayDeque<>(); //traverse the graph
        HashMap<String, Boolean> isVisited = new HashMap<>();
        queue.addLast(beginWord);  //add first word to the queue
        isVisited.put(beginWord, true); //add begin word to visited map

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                String currWord = queue.pollFirst();
                if (currWord.equals(endWord)) return pathLength + 1;
                for (int j = 0; j < L; j++) {
                    String pattern = currWord.substring(0, j) + '*' + currWord.substring(j + 1, L);
                    for (String intermediate: neighbors.get(pattern)) {
                        if (!isVisited.containsKey(intermediate)) {
                            isVisited.put(intermediate, true);
                            queue.addLast(intermediate);
                        }
                    }
                }
            }
            pathLength++;
        }
        return 0;
    }
}

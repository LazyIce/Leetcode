import java.util.*;

public class _127_WordLadder {
    /**
     * BFS
     * time: O(n)
     * space: O(n)
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>(); // like level traversal, queue stores the words for each level
        int level = 1; // length of transformation sequence
        int curNum = 1;  // #words in cur level
        int nextNum = 0;  // #words in next level
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                // try to change every character in word from 'a' to 'z'
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    // check whether this word is in wordlist
                    if (set.contains(temp)) {
                        // if the word equals endword, return level
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                        // update nextNum, queue, and set
                        nextNum++;
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
            // all words in current level is consumed, set it with nextNum
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }

    /**
     * BFS
     * time: O(n)
     * space: O(n)
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int curLevel = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return curLevel + 1;
                        }
                        map.put(temp, curLevel + 1);
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}

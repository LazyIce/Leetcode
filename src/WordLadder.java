/**
 * time: O(n*26^l) n=|wordList|, l=len(word)
 * space: O(n)
 */
import java.util.List;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class WordLadder {
    //BFS
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);

        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q.isEmpty()) {
            ++steps;
            for (int s = q.size(); s > 0; --s) {
                String w = q.poll();
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) continue;
                        chs[i] = c;
                        String t = new String(chs);
                        if (t.equals(endWord)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        q.offer(t);
                    }
                    chs[i] = ch;
                }
            }
        }
        return 0;
    }

    // Bidirectional BFS
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);

        if (!dict.contains(endWord)) return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            ++steps;

            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            Set<String> q = new HashSet<>();

            for (String w : q1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (q2.contains(t)) return steps + 1;
                        if (!dict.contains(t)) continue;
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }

            q1 = q;
        }
        return 0;
    }
}

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;


public class _642_DesignSearchAutocompleteSystem {
    class AutocompleteSystem {
        TrieNode root;
        String prefix;

        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            prefix = "";

            for (int i = 0; i < sentences.length; i++) {
                add(sentences[i], times[i]);
            }
        }

        public void add(String s, int count) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                TrieNode next = cur.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    cur.children.put(c, next);
                }
                cur = next;
                cur.counts.put(s, cur.counts.getOrDefault(s, 0) + count);
            }
            cur.isWord = true;
        }

        public List<String> input(char c) {
            if (c == '#') {
                add(prefix, 1);
                prefix = "";
                return new ArrayList<>();
            }

            prefix = prefix + c;
            TrieNode cur = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = cur.children.get(cc);
                if (next == null) {
                    return new ArrayList<>();
                }
                cur = next;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
            for (String s : cur.counts.keySet()) {
                pq.add(new Pair(s, cur.counts.get(s)));
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(pq.poll().s);
            }

            return res;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }

    class Pair {
        String s;
        int c;

        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

}

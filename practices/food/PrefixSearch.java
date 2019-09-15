import java.util.*;

public class PrefixSearch {
    public static void main(String[] args) {
        String[] content = new String[] {"Burger King", "bursh Burgers", "sad Burger", "Walburgers"};
        String[] prefixResult = prefixSearch(content, "bur");
        String[] nonPrefixResult = nonPrefixSearch(content, "bur");
        System.out.println(Arrays.toString(prefixResult));
        System.out.println(Arrays.toString(nonPrefixResult));
    }

//    public static String[] prefixSearch(String[] content, String prefix) {
//        List<String> res = new ArrayList<>();
//
//        for (String str : content) {
//            String[] words = str.split(" ");
//            for (String word : words) {
//                if (word.toLowerCase().startsWith(prefix) == 0) {
//                    res.add(str);
//                    break;
//                }
//            }
//        }
//
//        return res.toArray(new String[0]);
//    }

    public static String[] prefixSearch(String[] content, String prefix) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        MyTrie trie = new MyTrie();

        for (String str : content) {
            String[] words = str.split(" ");
            for (String word : words) {
                word = word.toLowerCase();
                trie.insert(word);
                List<String> word_list = map.getOrDefault(word, new ArrayList<>());
                word_list.add(str);
                map.put(word, word_list);
            }
        }

        MyTrieNode root = trie.find(prefix);
        Queue<MyTrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               MyTrieNode cur = queue.poll();
               if (cur.is_word) {
                   res.addAll(map.get(cur.word));
               }
               for (int j = 0; j < 26; j++) {
                   if (cur.children[j] != null) {
                       queue.offer(cur.children[j]);
                   }
               }
           }
        }

        return res.toArray(new String[0]);
    }

//    public static String[] nonPrefixSearch(String[] content, String substr) {
//        List<String> res = new ArrayList<>();
//
//        for (String str : content) {
//            String[] words = str.split(" ");
//            for (String word : words) {
//                if (word.toLowerCase().indexOf(substr) != -1) {
//                    res.add(str);
//                    break;
//                }
//            }
//        }
//
//        return res.toArray(new String[0]);
//    }
    public static String[] nonPrefixSearch(String[] content, String substr) {
        List<String> res = new ArrayList<>();
        KMP kmp = new KMP();
        for (String str : content) {
            String[] words = str.split(" ");
            for (String word : words) {
                if (kmp.kmp(word.toLowerCase(), substr) != - 1) {
                    res.add(str);
                    break;
                }
            }
        }

        return res.toArray(new String[0]);
    }
}

class MyTrieNode {
    boolean is_word;
    String word;
    MyTrieNode[] children;

    public MyTrieNode() {
        children = new MyTrieNode[26];
        is_word = false;
        word = "";
    }
}

class MyTrie {
    private MyTrieNode root;

    public MyTrie() {
        root = new MyTrieNode();
    }

    public void insert(String word) {
        MyTrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new MyTrieNode();
            }
            p = p.children[index];
        }
        p.is_word = true;
        p.word = word;
    }

    public MyTrieNode find(String prefix) {
        MyTrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (p.children[index] == null) {
                return null;
            }
            p = p.children[index];
        }

        return p;
    }
}

class KMP {
    public void getNext(String pattern, int next[]) {
        int j = 0;
        int k = -1;
        int len = pattern.length();
        next[0] = -1;

        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    public int kmp(String s, String pattern) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();

        int[] next = new int[plen];

        getNext(pattern, next);

        while (i < slen && j < plen) {
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }

            }

            if (j == plen) {
                return i - j;
            }
        }

        return -1;
    }
}
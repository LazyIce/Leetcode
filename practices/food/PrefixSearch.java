import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PrefixSearch {
    public static void main(String[] args) {
        String[] content = new String[] {"Burger King", "kdk dnsd Burgers", "sad Burger's", "asdd das a", "Walburgers"};
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
//                if (word.toLowerCase().indexOf(prefix) == 0) {
//                    res.add(str);
//                    break;
//                }
//            }
//        }
//
//        return res.toArray(new String[0]);
//    }

    public static String[] prefixSearch(String[] content, String prefix) {
        List<String> res = new ArrayList<>();

        for (String str : content) {
            String[] words = str.split(" ");
            for (String word : words) {
                if ()
            }
        }

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
        return new String[0];
    }
}

class TrieNode {
    public boolean is_word;
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
        is_word = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.is_word = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.is_word;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }

    private TrieNode find(String prefix) {
        TrieNode p = root;
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

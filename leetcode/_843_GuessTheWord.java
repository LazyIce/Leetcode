import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _843_GuessTheWord {
    public void findSecretWord1(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) {
            return;
        }

        int n = wordlist.length;
        int l = wordlist[0].length();
        int[][] f = new int[n][n];

        Set<Integer> possible = new HashSet<>();
        for (int i = 0; i < n; i++) {
            possible.add(i);
        }
        while (!possible.isEmpty()) {
            // pick the first word in the set brainlessly
            Iterator<Integer> iterator = possible.iterator();
            int choice = iterator.next();

            int matches = master.guess(wordlist[choice]);
            if (matches == l) { // we found the match!
                return;
            }
            Set<Integer> possible2 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                // This is the key!
                // Candidates are among the words that have the same number of matches with the guessed word as the returned matches
                // And candidates must be among the list (set) of candidates remained from previous guesses
                if (countMatches(wordlist[choice], wordlist[i]) == matches && possible.contains(i)) {
                    possible2.add(i);
                }
            }
            possible = possible2;
        }
    }

    public void findSecretWord2(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>();
        for (String str: wordlist)
            list.add(str);
        for(int i = 0 ; i < 10 ; i++) {
            Map<String, Integer> zeroMatch = new HashMap<>();
            for(String s1: list) {
                zeroMatch.putIfAbsent(s1, 0);
                for(String s2: list) {
                    if(countMatches(s1, s2) == 0) {
                        zeroMatch.put(s1, zeroMatch.get(s1) + 1);
                    }
                }
            }
            Pair pair = new Pair("", 101); // list size is 100
            for(String key : zeroMatch.keySet()) {
                if(zeroMatch.get(key) < pair.freq) {
                    pair = new Pair(key, zeroMatch.get(key));
                }
            }
            int matchNum = master.guess(pair.key);
            if(matchNum == 6)
                return;
            List<String> tmp = new ArrayList<>();
            for(String s: list) {
                if(countMatches(s, pair.key) == matchNum) {
                    tmp.add(s);
                }
            }
            list = tmp;
        }
    }

    private int countMatches(String word1, String word2) {
        int l = word1.length();
        int matches = 0;
        for (int k = 0; k < l; k++) {
            if (word1.charAt(k) == word2.charAt(k)) {
                matches++;
            }
        }
        return matches;
    }
}

class Master {
    public Master() {}

    public int guess(String word) {
        return 0;
    }
}

class Pair {
    String key;
    int freq;
    public Pair(String key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}

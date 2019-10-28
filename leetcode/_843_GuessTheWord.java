import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class _843_GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
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

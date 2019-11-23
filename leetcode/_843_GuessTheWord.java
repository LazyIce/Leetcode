import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _843_GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>();
        for (String str: wordlist)
            list.add(str);
        for(int i = 0 ; i < 10 ; i++) {
            Map<String, Integer> zeroMatch = new HashMap<>();
            for (String s1: list) {
                zeroMatch.putIfAbsent(s1, 0);
                for (String s2: list) {
                    if (match(s1, s2) == 0) {
                        zeroMatch.put(s1, zeroMatch.get(s1) + 1);
                    }
                }
            }
            Pair pair = new Pair("", 101); // list size is 100
            for (String key : zeroMatch.keySet()) {
                if (zeroMatch.get(key) < pair.freq) {
                    pair = new Pair(key, zeroMatch.get(key));
                }
            }
            int matchNum = master.guess(pair.key);
            if (matchNum == 6)
                return;
            List<String> tmp = new ArrayList<>();
            for (String s: list) {
                if (match(s, pair.key) == matchNum) {
                    tmp.add(s);
                }
            }
            list = tmp;
        }
    }

    public int match(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                res++;
            }
        }

        return res;
    }

    class Pair {
        String key;
        int freq;

        public Pair(String key, int freq) {
            this.key = key;
            this.freq = freq;
        }
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

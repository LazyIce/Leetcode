import java.util.HashMap;
import java.util.Map;

public class CloseEnoughString {
    public static void main(String[] args) {
        String s1 = "babzccc";
        String s2 = "abbzccz";

        boolean res = true;

        if (s1.length() != s2.length()) {
            res = false;
        }

        Map<Character, Integer> letterMap1 = new HashMap<>();
        Map<Character, Integer> letterMap2 = new HashMap<>();
        for (Character ch : s1.toCharArray()) {
            letterMap1.put(ch, letterMap1.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : s2.toCharArray()) {
            letterMap2.put(ch, letterMap2.getOrDefault(ch, 0) + 1);
        }

        if (!letterMap1.keySet().equals(letterMap2.keySet())) {
            res = false;
        }

        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        for (Integer value : letterMap1.values()) {
            countMap1.put(value, countMap1.getOrDefault(value, 0) + 1);
        }

        for (Integer value : letterMap2.values()) {
            countMap2.put(value, countMap2.getOrDefault(value, 0) + 1);
        }

        if (!countMap1.equals(countMap2)) {
            res = false;
        }

        System.out.println(res);
    }
}

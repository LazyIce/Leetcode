import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0)+1);
            char ch2 = t.charAt(i);
            map.put(ch2, map.getOrDefault(ch2, 0)-1);
        }

        for (Integer value: map.values()) {
            if (value != 0)
                return false;
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] hash = new int[256];

        for(int i = 0 ; i < s.length(); i++){
            char x = s.charAt(i);
            hash[x]++;
            char c = t.charAt(i);
            hash[c]--;
        }

        int sum = 0;

        for(int m:hash){
            if(m != 0) return false;

        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if(s.length()!= t.length())
            return false;
        int[] asciiSet = new int[256];
        for(char c : s.toCharArray())
            asciiSet[c]++;
        for(char c : t.toCharArray())
            if(asciiSet[c]-- == 0)
                return false;
        return true;
    }
}

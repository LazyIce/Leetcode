import java.util.Map;
import java.util.HashMap;

public class _290_WordPattern {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; i++)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}

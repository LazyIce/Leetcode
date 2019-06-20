import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class _187_RepeatedDNASequences {
    /**
     * time: O(n)
     * space: O(n)
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10)
            return new ArrayList<>();

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            if (!seen.add(temp)) {
                repeated.add(temp);
            }
        }

        return new ArrayList<>(repeated);
    }
}

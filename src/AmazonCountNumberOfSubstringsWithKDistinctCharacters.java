/**
 * time: O(n^2)
 * space: O(n)
 */

import java.util.*;

public class AmazonCountNumberOfSubstringsWithKDistinctCharacters {
    public static List<String> countkDist(String str, int k) {
        List<String> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        Set<String> temp = new HashSet<>();
        int len = str.length();
        int cnt[] = new int[26];
        for (int i = 0; i <= len - k; i++) {
            StringBuilder sb = new StringBuilder();
            int dist_count = 0;
            Arrays.fill(cnt, 0);
            for (int j = i; j < i + k; j++) {
                if (cnt[str.charAt(j) - 'a'] == 0) {
                    dist_count++;
                }
                sb.append(str.charAt(j));
                cnt[str.charAt(j) - 'a']++;
                if (dist_count == k)
                    temp.add(sb.toString());
            }
        }
        res.addAll(temp);
        return res;
    }

    public static List<String> countkDistWithOneRepeat(String str, int k) {
        List<String> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        Set<String> temp = new HashSet<>();
        int len = str.length();
        int cnt[] = new int[26];
        for (int i = 0; i <= len - k; i++) {
            StringBuilder sb = new StringBuilder();
            int dist_count = 0;
            Arrays.fill(cnt, 0);
            for (int j = i; j < i + k; j++) {
                if (cnt[str.charAt(j) - 'a'] == 0) {
                    dist_count++;
                }
                sb.append(str.charAt(j));
                cnt[str.charAt(j) - 'a']++;
                if (dist_count == k - 1 && sb.length() == k)
                    temp.add(sb.toString());
            }
        }
        res.addAll(temp);
        return res;
    }

    public static void main(String[] args) {
        String ch = "abcdkeewrf";
        int k = 4;
        System.out.println("Total substrings with exactly " +
                k +    " distinct characters : "
                + countkDist(ch, k));
        System.out.println("Total substrings with exactly " +
                k +    " one repeat character : "
                + countkDistWithOneRepeat(ch, k));
    }
}
import java.util.HashSet;
import java.util.Set;

public class ShortestSubstring {
    public static void main(String[] args) {
        String str = "dabbcabcd";

        int n = str.length();

        int dist_count = 0;

        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }

        dist_count = set.size();

        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;

        int count = 0;
        int[] curr_count =  new int[256];
        for (int j = 0; j < n; j++) {

            curr_count[str.charAt(j)]++;

            if (curr_count[str.charAt(j)] == 1) {
                count++;
            }

            if (count == dist_count) {
                while (curr_count[str.charAt(start)] > 1) {
                    if (curr_count[str.charAt(start)] > 1) {
                        curr_count[str.charAt(start)]--;
                    }
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        System.out.println(str.substring(start_index, start_index+min_len));
    }
}

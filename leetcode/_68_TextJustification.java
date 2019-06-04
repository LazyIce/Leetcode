import java.util.List;
import java.util.ArrayList;

public class _68_TextJustification {
    /**
     * time: O(n)
     * space: O(n)
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            // find the number of words in each line
            // n words + n - 1 spaces <= maxWidth
            int count = words[index].length();   // the length of current row
            int last = index + 1;   // the index of last word in current row
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }
            // calculate spaces and get the current row
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);   // append first word
            int diff = last - index - 1;   // remained words in current row
            // last row or no other words, left justification
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // full justification
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        builder.append(" ");
                    }
                    if (r > 0) {
                        builder.append(" ");
                        r--;
                    }
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            res.add(builder.toString());
            index = last;
        }
        return res;
    }
}

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class _1087_BraceExpansion {
    /**
     * DFS
     */
    public String[] expand1(String S) {
        TreeSet<String> set = new TreeSet<>();
        if (S.length() == 0) {
            return new String[]{""};
        } else if (S.length() == 1) {
            return new String[]{S};
        }
        if (S.charAt(0) == '{') {
            int i = 0; // keep track of content in the "{content}"
            while (S.charAt(i) != '}') {
                i++;
            }
            String sub = S.substring(1, i);
            String[] subs = sub.split(",");
            String[] strs = expand1(S.substring(i + 1)); // dfs
            for (int j = 0; j < subs.length; j++) {
                for (String str : strs) {
                    set.add(subs[j] + str);
                }
            }
        } else {
            String[] strs = expand1(S.substring(1));
            for (String str : strs) {
                set.add(S.charAt(0) + str);
            }
        }
        return set.toArray(new String[0]);
    }

    /**
     * Backtracking
     */
    public String[] expand2(String S) {
        List<String> res = new ArrayList<>();
        dfs(S, 0, new StringBuilder(), res);

        String[] out = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            out[i] = res.get(i);
        }
        return out;
    }

    private void dfs(String s, int index, StringBuilder sb, List<String> res) {
        if (index == s.length()) {
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int position = sb.length();
        if (c == '{') {
            List<Character> charList = new ArrayList<>();
            int endIndex = index + 1;
            while (endIndex < s.length() && s.charAt(endIndex) != '}') {
                if (Character.isLetter(s.charAt(endIndex))) {
                    charList.add(s.charAt(endIndex));
                }
                endIndex++;
            }

            Collections.sort(charList);
            for (char d : charList) {
                sb.append(d);
                dfs(s, endIndex + 1, sb, res);
                sb.setLength(position);
            }
        } else if (Character.isLetter(c)) {
            sb.append(s.charAt(index));
            dfs(s, index + 1, sb, res);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Echo {
    public static void main(String[] args) {
        String test1 = "_{a,b,c}{1,2}";
        String test2 = "_avc{";
        String test3 = "_{a,c,v}}{b,c}#";
        System.out.println(echo(test1));
        System.out.println(echo(test2));
        System.out.println(echo(test3));
    }

    public static String echo(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, new StringBuilder(), res);
        return String.join(",", res);
    }

    public static void dfs(String s, int index, StringBuilder sb, List<String> res) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }

        Character ch = s.charAt(index);
        int position = sb.length();
        if (ch == '{') {
            if ((index + 1 < s.length() && s.charAt(index + 1) == '{') || index + 1 == s.length()) {
                sb.append(ch);
                dfs(s, index + 1, sb, res);
            } else {
                List<Character> list = new ArrayList<>();
                index++;
                while (index < s.length() && s.charAt(index) != '}') {
                    if (Character.isLetterOrDigit(s.charAt(index))) {
                        list.add(s.charAt(index));
                    }
                    index++;
                }
                for (Character c : list) {
                    sb.append(c);
                    dfs(s, index + 1, sb, res);
                    sb.setLength(position);
                }
            }
        } else if (ch == '_' || ch == '#' || ch == '}' || Character.isLetterOrDigit(ch)) {
            sb.append(ch);
            dfs(s, index + 1, sb, res);
        }
    }
}

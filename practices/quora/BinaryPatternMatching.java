import java.util.HashSet;
import java.util.Set;

public class BinaryPatternMatching {
    public static void main(String[] args) {
        String pattern = "011";
        String match = "fsadasdsafas";

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; j < match.length(); j++) {
            char cur = match.charAt(j);
            if (vowels.contains(cur)) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            if ((j - i + 1) == pattern.length()) {
                if (sb.toString().equals(pattern)) {
                    res++;
                }
                i++;
                sb.deleteCharAt(0);
            }
        }

        System.out.println(res);
    }

}

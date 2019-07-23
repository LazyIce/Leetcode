import java.util.Stack;

public class _394_DecodeString {
    /**
     * Two Stacks
     * time: O(n)
     * space: O(n)
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            } else if (s.charAt(i) == '[') {
                strStack.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int num = countStack.pop();
                for (int j = 0; j < num; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }

        return res;
    }
}

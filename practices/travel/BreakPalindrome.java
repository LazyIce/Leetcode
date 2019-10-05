public class BreakPalindrome {
    public static void main(String[] args) {
        String s = "aabaa";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a') {
                if (s.length() % 2 != 0 && i == s.length() / 2) {
                    System.out.println("IMPOSSIBLE");
                    break;
                } else {
                    System.out.println(s.substring(0, i) + 'a' + s.substring(i + 1));
                    break;
                }
            }
        }
    }
}

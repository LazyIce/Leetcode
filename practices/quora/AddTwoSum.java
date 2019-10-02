public class AddTwoSum {
    public static void main(String[] args) {
        String s = "99";
        String t = "1";


        StringBuilder sb = new StringBuilder();
        int len = Math.min(s.length(), t.length());
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i < len; i++) {
            int a = s.charAt(lenS - i - 1) - '0';
            int b = t.charAt(lenT - i - 1) - '0';
            int sum = a + b;
            sb.insert(0, sum);
        }
        String res = sb.toString();
        if (lenS > len) {
            res = s.substring(0, lenS - len) + res;
        }
        if (lenT > len) {
            res = t.substring(0, lenT - len) + res;
        }

        System.out.println(res);
    }
}

public class RemoveOneDigit {
    public static void main(String[] agrs) {
        String s = "cbc";
        String t = "cb";
        System.out.println(getRemoveWays(s, t));
    }

    public static int getRemoveWays(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i) + s.substring(i + 1);
            if (temp.compareTo(t) < 0) {
                res++;
            }
        }
        for (int i = 0; i < t.length(); i++) {
            String temp = t.substring(0, i) + t.substring(i + 1);
            if (temp.compareTo(s) > 0) {
                res++;
            }
        }

        return res;
    }
}

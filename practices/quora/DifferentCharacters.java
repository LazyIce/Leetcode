public class DifferentCharacters {
    public static void main(String[] args) {
        String str = "aabdcreff";

        int res = 0;

        int idx = 2;
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);
        while (ch1 == ch2) {
            ch1 = ch2;
            ch2 = str.charAt(idx);
            idx++;
        }

        for (int i = idx; i < str.length(); i++) {
            char ch3 = str.charAt(i);
            if (ch3 == ch1) {
                ch1 = ch2;
                ch2 = ch3;
            } else if (ch3 == ch2) {
                ch1 = ch2;
                if (i < str.length() - 1) {
                    i++;
                    ch2 = str.charAt(i);
                } else {
                    break;
                }
            } else {
                res++;
                ch1 = ch2;
                ch2 = ch3;
            }
        }

        System.out.println(res);
    }
}

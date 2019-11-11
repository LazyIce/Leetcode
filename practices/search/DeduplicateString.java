public class DeduplicateString {
    public static void main(String[] args) {
        System.out.println(deduplicate("aAabbccad"));
    }

    public static String deduplicate(String str) {
        char[] chs = str.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < chs.length) {
            if (slow == 0) {
                chs[slow++] = chs[fast];
            } else {
                if (Character.isUpperCase(chs[slow -1]) && Character.isLowerCase(chs[fast]) || Character.isLowerCase(chs[slow-1]) && Character.isUpperCase(chs[fast])) {
                    char c1 = Character.toLowerCase(chs[slow-1]);
                    char c2 = Character.toLowerCase(chs[fast]);
                    if(c1 == c2) {
                        slow--;
                    } else {
                        chs[slow++] = chs[fast];
                    }
                } else {
                    chs[slow++] = chs[fast];
                }
            }
            fast++;
        }

        return new String(chs, 0, slow);
    }
}

public class RameWindow {
    public static void main(String[] args) {
        int n = 6;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < n; j++) {
                    sb.append('*');
                }
            } else {
                sb.append('*');
                for (int j = 1; j < n - 1; j++) {
                    sb.append(' ');
                }
                sb.append('*');
            }
            res[i] = sb.toString();
        }

        for (String ans : res) {
            System.out.println(ans);
        }
    }
}

public class CalDigitPairs {
    public static void main(String[] args) {
        int num = 12345;
        char[] arr = String.valueOf(num).toCharArray();
        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (i % 2 == 0) {
                res -= (arr[i - 1] - '0');
            } else {
                res += (arr[i - 1] - '0');
            }
        }

        System.out.println(res);
    }
}

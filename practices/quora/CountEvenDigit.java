public class CountEvenDigit {
    public static void main(String[] args) {
        int[] arr = new int[] {12, 3, 5, 3456};

        int res = 0;

        for (Integer num : arr) {
            int count = 0;
            while (num != 0) {
                num /= 10;
                count++;
            }
            if (count % 2 == 0) {
                res++;
            }
        }

        System.out.println(res);
    }
}

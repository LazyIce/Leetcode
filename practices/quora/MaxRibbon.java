public class MaxRibbon {
    public static void main(String[] args) {
        System.out.println(ribbon(new int[]{1,2,3,4,9}, 5));
    }

    private static int ribbon(int[] arr, int k) {
        int high = 0;
        for (int i : arr) {
            high = Math.max(high, i);
        }

        int low = 1;
        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cur = 0;
            for (int i : arr) {
                cur += i / mid;
            }
            if (cur >= k) {
                res = Math.max(res, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}

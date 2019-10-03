public class LongestEqualSubarray {
    public static void main(String[] args) {
        /*
        0 1 1 0
        0 0 0 1 1
         */

        System.out.println(getLongestEqualSubarray(new int[] {0, 1, 1, 0, 1, 0, 1}));
        System.out.println(getLongestEqualSubarray(new int[] {0, 1, 1, 0}));
        System.out.println(getLongestEqualSubarray(new int[] {0, 0, 0, 1, 1}));
    }

    public static int getLongestEqualSubarray(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if (count0 == count1) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }
}

public class WeirdyFaculty {
    public static void main(String[] args) {
        int[] v = new int[] {1, 0, 0, 1, 0};
        System.out.println(getK(v));
    }

    public static int getK(int[] v) {
        for (int i = -1; i < v.length; i++) {
            int mySum = 0;
            int friendSum = 0;

            mySum = getSum(v, 0, i);
            friendSum = getSum(v, i + 1, v.length - 1);
            if (mySum > friendSum) {
                return i + 1;
            }
        }

        return -1;
    }

    public static int getSum(int[] v, int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            if (v[i] == 1) {
                sum++;
            } else {
                sum--;
            }
        }

        return sum;
    }
}

public class GoodTuples {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 1, 5, 3, 2, 3};
        int res = 0;

        boolean pair = false;
        int num1 = arr[0];
        int num2 = arr[1];

        for (int i = 2; i < arr.length; i++) {
            pair = num1 == num2;
            int num3 = arr[i];
            if ((pair && num3 != num2) || (!pair && num3 == num1 || num3 == num2)) {
                res++;
            }
            num1 = num2;
            num2 = num3;
        }

        System.out.println(res);
    }
}

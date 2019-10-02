public class ProductAndSum {
    public static void main(String[] args) {
        int num = 230;

        int product = 1;
        int sum = 0;

        while (num != 0) {
            int remainder = num % 10;
            num = num / 10;
            sum += remainder;
            product *= remainder;
        }

        int res = product - sum;

        System.out.println(res);
    }
}

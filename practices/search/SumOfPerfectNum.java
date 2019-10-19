public class SumOfPerfectNum {
    public static void main(String[] args) {
        System.out.println(getSumOfPerfectNum(10));
    }

    public static int getSumOfPerfectNum(int n) {
        int res = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            res += i * i;
        }

        return res;
    }
}

public class AddDigits {
    public int addDigits1(int num) {
        if (num < 10)
            return num;
        int temp = 0;

        while (num != 0) {
            temp += num % 10;
            num = num / 10;
        }

        return addDigits1(temp);
    }

    /**
     * without loop/recursion
     * time: O(1)
     * N=(a[0] * 1 + a[1] * 10 + ...a[n] * 10 ^n),and a[0]...a[n] are all between [0,9]
     * we set M = a[0] + a[1] + ..a[n]
     * and another truth is that:
     * 1 % 9 = 1
     * 10 % 9 = 1
     * 100 % 9 = 1
     * so N % 9 = a[0] + a[1] + ..a[n]
     * means N % 9 = M
     * so N = M (% 9)
     */
    public int addDigits2(int num) {
        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }
}

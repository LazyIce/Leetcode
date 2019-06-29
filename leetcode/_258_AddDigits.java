public class _258_AddDigits {
    /**
     * time: TBD
     * space: O(1)
     */
    public int addDigits(int num) {
        if (num < 10)
            return num;
        int temp = 0;

        while (num != 0) {
            temp += num % 10;
            num = num / 10;
        }

        return addDigits(temp);
    }
}

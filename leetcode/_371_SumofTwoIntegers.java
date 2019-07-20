public class _371_SumofTwoIntegers {
    /**
     * Bit Manipulation
     * time: O(logn)
     * space: O(1)
     */
    public int getSum(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        while (b != 0) {
            int carry = a & b; // calculate carry
            a = a ^ b; // add bit, 0 + 0 = 0, 0 + 1 = 1, 1 + 1 = 2
            b = carry << 1;
        }

        return a;
    }
}

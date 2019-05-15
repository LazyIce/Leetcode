public class PowerOfTwo {
    // Iterative
    public boolean isPowerOfTwo1(int n) {
        if (n == 0)
            return false;
        while (n%2 == 0)
            n/=2;
        return n == 1;
    }

    // Recursion
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo2(n/2)));
    }

    // Bit Operation
    public boolean isPowerOfTwo3(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
}

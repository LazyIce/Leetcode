public class _50_Pow {
    /**
     * Divide and Conquer
     * Recursive
     * time: O(logn)
     * space: O(logn)
     */
    public double myPow1(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return  1.0 / pow(x, n);
        }
    }

    public double pow (double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    /**
     * Iterative
     * time: 0(logn)
     * space: O(1)
     */
    public double myPow2(double x, int n) {
        if (n == 0)
            return 1;
        double res = 1;
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }
}

public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        boolean positive = true;
        if (x < 0)
            positive = false;
        int newX = Math.abs(x);
        while (newX > 0) {
            res = res * 10 + (newX % 10);
            newX = newX / 10;
        }
        res = positive ? res : res * (-1);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            res = 0;
        return (int)res;
    }
}

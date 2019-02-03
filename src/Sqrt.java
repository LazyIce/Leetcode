public class Sqrt {
    public int sqrt(int x) {
        // find the last number num which num * num <= x
        if (x < 2) {
            return x;
        }
        long begin = 1, end = x / 2 + 1;
        while ( begin + 1 < end) {
            long mid = begin + (end - begin) /2;
            if (mid * mid <= x) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return (int)end;
        }
        return (int)begin;
    }
}

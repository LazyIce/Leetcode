public class ReachingPoint {
    public static void main(String[] args) {
        System.out.println(canReach(1, 4, 5, 9));
    }

    public static String canReach(int x1, int y1, int x2, int y2) {
        while (x2 >= x1 && y2 >= y1) {
            if (x2 > y2) {
                if (y2 == y1)
                    return (x2 - x1) % y2 == 0 ? "Yes" : "No";
                x2 %= y2;
            } else {
                if (x2 == x1)
                    return (y2 - y1) % x2 == 0 ? "Yes" : "No";
                else
                    y2 %= x2;
            }
        }
        return x2 == x1 && y2 == y1 ? "Yes" : "No";
    }
}

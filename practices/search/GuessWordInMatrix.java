public class GuessWordInMatrix {
    public static int guess(int i1, int j1, int i2, int j2) {
        int x = 3; int y = 1;
        int dist1 = Math.abs(i1 - x) + Math.abs(j1 - y);
        int dist2 = Math.abs(i2 - x) + Math.abs(j2 - y);
        return dist1 - dist2;
    }

    private static void guessGift(int rows, int cols) {
        int left = 0, right = cols - 1;
        while (left < right) {
            int res = guess(0, left, 0, right);
            int mid = left + (right - left) / 2;
            if(res == 0) {
                left = mid;
                break;
            } else if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int top = 0, bot = rows - 1;
        while (top < bot) {
            int mid = top + (bot - top) / 2;
            int res = guess(top, left, bot, left);
            if(res == 0) {
                break;
            } else if (res < 0) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        System.out.println(top + ", " + left);
    }
}

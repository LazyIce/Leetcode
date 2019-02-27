import java.util.Random;

public class RandomPickWithWeight {
    private Random rand = new Random();
    private int[] sums;

    public void Solution(int[] w) {
        sums = new int[w.length];
        sums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sums[i] = w[i] + sums[i - 1];
        }
    }

    public int pickIndex() {
        int randValue = rand.nextInt(sums[sums.length - 1]);
        return binarySearch(randValue);
    }

    private int binarySearch(int target) {
        int lo = 0, hi = sums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}

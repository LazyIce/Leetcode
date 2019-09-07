public class EfficientJobProcessingService {
    public static void main(String[] args) {
        int[] tasks = new int[] {2, 2, 3, 4};
        int[] weights = new int[] {2, 4, 4, 5};
        System.out.println(getMaxWeight(weights, tasks, 14));
    }

    public static int getMaxWeight(int[] weights, int[] tasks, int p) {
        int res = 0;

        for (int i = 0; i < tasks.length; i++) {
            tasks[i] *= 2;
        }

        int[] dp = new int[p + 1];

        for (int i = 1; i <= tasks.length; i++) {
            for (int j = p; j >= tasks[i - 1]; j--) {
                dp[j] = Math.max(dp[j - tasks[i - 1]] + weights[i - 1], dp[j]);
            }
        }

        return dp[p];
    }
}

public class _837_New21Game {
    /**
     dp[i] is the probability that we get points i at some moment.
     In another word:
     1 - dp[i]is the probability that we skip the points i.

     The do equation is that:
     dp[i] = sum(last W dp values) / W

     To get Wsum = sum(last W dp values),
     we can maintain a sliding window with size at most W.
     */
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) {
            return 1;
        }
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) {
                Wsum += dp[i];
            } else {
                res += dp[i];
            }
            if (i - W >= 0) {
                Wsum -= dp[i - W];
            }
        }
        return res;
    }
}

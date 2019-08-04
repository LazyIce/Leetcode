public class _552_StudentAttendanceRecordII {
    /**
     * time: O(n)
     * space: O(n)
     */
    static final int M = 1000000007;

    public int checkRecord(int n) {
        long[] PorL = new long[n + 1];
        long[] P = new long[n + 1];
        PorL[0] = P[0] = 1;
        PorL[1] = 2;
        P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }
        long res = PorL[n];
        for (int i = 0; i < n; i++) {
            long insertA = (PorL[i] * PorL[n - 1 - i]) % M;
            res = (res + insertA) % M;
        }
        return (int)res;
    }
}

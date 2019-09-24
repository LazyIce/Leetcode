/**
 * time: O(n)
 * space: O(1)
 */
public class _1007_MimimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) {
            return -1;
        }
        int[] countA = new int[6];
        int[] countB = new int[6];
        int[] same = new int[6];

        for (int i = 0; i < A.length; i++) {
            countA[A[i] - 1]++;
            countB[B[i] - 1]++;
            if (A[i] == B[i]) {
                same[A[i] - 1]++;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (countA[i] + countB[i] - same[i] >= A.length) {
                return Math.min(countA[i], countB[i]) - same[i];
            }
        }

        return -1;
    }
}

import java.util.Arrays;

public class PsychometricTesting {
    public static int[] jobOffers(int score_size, int[] scores, int lowerLimits_size, int[] lowLimits, int upperLimits_size, int[] upperLimits) {
        int[] res = new int[lowerLimits_size];
        Arrays.sort(scores);
        for (int i = 0; i < lowerLimits_size; i++) {
            int index1 = Arrays.binarySearch(scores, lowLimits[i]);
            int index2 = Arrays.binarySearch(scores, upperLimits[i]);
            index1 = index1 >= 0 ? index1 : -index1 - 1;
            index2 = index2 >= 0 ? index2 : -index2 - 1;
            if (index1 < 0 && index2 < 0)
                res[i] = index2 - index1 - 1;
            else if (index1 > 0 && index2 > 0)
                res[i] = index2 - index1 + 1;
            else
                res[i] = index2 - index1;
            res[i] = index2 - index1 + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] scores = new int[]{4, 8, 7};
        int[] lowerLimits = new int[]{2, 4};
        int[] upperLimits = new int[]{8, 4};
        int[] res = jobOffers(3, scores, 2, lowerLimits, 2, upperLimits);
        for (int i : res)
            System.out.println(i);
    }
}

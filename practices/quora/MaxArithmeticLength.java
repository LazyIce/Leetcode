import java.util.HashSet;
import java.util.Set;

public class MaxArithmeticLength {
    public static void main(String[] agrs) {
        int[] s = new int[]{0, 4, 8, 20};
        int[] t = new int[]{5, 7, 12, 16, 24};
        System.out.println(getMaxArithmeticLength(s, t));
    }

    public static int getMaxArithmeticLength(int[] s, int[] t) {
        Set<Integer> setT = new HashSet<>();
        for (int num : t) {
            setT.add(num);
        }

        int res = -1;
        int diff = s[1] - s[0];
        for (int i = diff; i > 0; i--) {
            int count = 2;
            int num = i + s[1];
            for (int j = 2; j < s.length; j++) {
                while (s[j] != num) {
                    if (setT.contains(num)) {
                        num = num + i;
                        count++;
                    } else {
                        count = -1;
                        break;
                    }
                }
                if (count == -1) {
                    break;
                } else {
                    count++;
                    num = num + i;
                }
            }

            if (count != -1) {
                num = s[0] - diff;
                while (setT.contains(num)) {
                    count++;
                    num -= diff;
                }
                num = s[s.length - 1] + diff;
                while (setT.contains(num)) {
                    count++;
                    num += diff;
                }
            }

            res = Math.max(res, count);
        }

        return res;
    }
}

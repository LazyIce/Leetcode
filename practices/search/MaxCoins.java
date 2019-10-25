import java.util.List;
import java.util.ArrayList;

public class MaxCoins {
    private static int res = 0;

    public static void main(String[] args) {
        int[][] coins = new int[][] {{1, 100, 3}, {7, 8, 9}};
        int k = 4;
        getMaxCoins(coins, k, new ArrayList<>(), 0);
        System.out.print(res);
    }

    public static void getMaxCoins(int[][] coins, int k, List<Integer> list, int start) {
        if (k == 0) {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            res = Math.max(sum, res);
            return;
        }
        if (start == coins.length || k < 0) {
            return;
        }
        for (int i = 0; i <= Math.min(coins[start].length, k); i++) {
            int pos = list.size();
            for (int j = 0; j < i; j++) {
                list.add(coins[start][j]);
            }
            getMaxCoins(coins, k - i, list, start + 1);
            while (list.size() > pos) {
                list.remove(list.size() - 1);
            }
        }
    }
}

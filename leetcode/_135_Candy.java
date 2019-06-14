import java.util.Arrays;

public class _135_Candy {
    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(n)
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1); // give one candy to each person at first

        // go from left to right
        // add candy for person who has higher rating than left person
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // go from right to left
        // add candy for person who has higher rating than right person
        for (int i = candies.length - 2; i >= 0; i --) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int res = 0;
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }
}

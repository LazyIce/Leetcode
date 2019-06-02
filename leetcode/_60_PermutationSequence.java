import java.util.List;
import java.util.ArrayList;

public class _60_PermutationSequence {
    /**
     * time: O(n^2)
     * space: O(n)
     E.g: n = 4, k = 17
     In all permutations, first number appears the same for 6(3!) times,
     the second number appears the same for 2(2!) times
     the third number and fourth number appears for the same for 1 time.
     the index of 17th is 16.
     16 / 6 = 2 so the first number should be 3
     Do it iteratively
     */
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        // get the times for appearing for each number in [1,n]
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        // index of kth permutation
        k = k - 1;
        // find the permutation
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();
    }
}

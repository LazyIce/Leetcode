import java.util.PriorityQueue;

public class _313_SuperUglyNumber {
    /**
     * Dynamic Programming
     * time: O(nk)
     * space: O(n+k)
     */
    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] count = new int[primes.length];
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            // find the smallest candidate
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * res[count[j]]);
            }
            res[i] = min;

            // add the count
            for (int j = 0; j < count.length; j++) {
                // add index of prime to avoid duplicates
                if (res[count[j]] * primes[j] == min) {
                    count[j]++;
                }
            }
        }

        return res[n - 1];
    }

    /**
     * PriorityQueue
     * time: O(n*logk)
     * space: O(max(n,k))
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;

        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Num(primes[i], 1, primes[i]));
        }

        for (int i = 1; i < n; i++) {
            res[i] = pq.peek().val;
            while (pq.peek().val == res[i]) {
                Num next = pq.poll();
                pq.add(new Num(next.prime * res[next.index], next.index + 1, next.prime));
            }
        }

        return res[n - 1];
    }

    class Num {
        int val;
        int index;
        int prime;

        public Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
}

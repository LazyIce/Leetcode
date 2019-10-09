import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class _1057_CampusBikes {
    /**
     * time: O(m*n*log(m*n))
     * space: O(m*n)
     */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visitedBikes = new boolean[bikes.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2){
                if (o1.distance == o2.distance) {
                    if(o1.workerIndex == o2.workerIndex){
                        return o1.bikeIndex - o2.bikeIndex;
                    }
                    return o1.workerIndex - o2.workerIndex;
                } else {
                    return o1.distance - o2.distance;
                }
            }
        });

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pq.offer(new Pair(i, j, distance));
            }
        }

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        int count = 0;
        while (count != workers.length) {
            Pair cur = pq.poll();
            int index = cur.workerIndex;
            int bike = cur.bikeIndex;
            if(res[index] == -1 && !visitedBikes[bike]){
                res[index] = bike;
                visitedBikes[bike] = true;
                count++;
            }
        }

        return res;
    }

    class Pair {
        int bikeIndex;
        int workerIndex;
        int distance;

        public Pair(int workerIndex, int bikeIndex, int distance) {
            this.workerIndex = workerIndex;
            this.bikeIndex = bikeIndex;
            this.distance = distance;
        }
    }
}

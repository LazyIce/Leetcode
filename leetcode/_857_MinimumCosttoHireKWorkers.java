import java.util.Arrays;
import java.util.PriorityQueue;

public class _857_MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int len = quality.length;
        Worker[] worker = new Worker[len];
        for(int i = 0 ; i < len ; i++) {
            worker[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(worker, (a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Worker> pq = new PriorityQueue<>((a, b) -> b.quality - a.quality);
        int sum = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if(pq.size() >= K) {
                Worker tmp = pq.poll();
                sum -= tmp.quality;
            }
            pq.offer(worker[i]);
            sum += worker[i].quality;
            if (pq.size() == K) {
                min = Math.min(min, sum * worker[i].ratio);
            }
        }

        return min;
    }

    class Worker {
        int quality;
        int wage;
        double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double)wage / quality;
        }
    }
}

import java.util.Queue;
import java.util.LinkedList;

public class _346_MovingAveragefromDataStream {
    class MovingAverage {
        private Queue<Integer> queue;
        private int size;
        private double sum;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.remove();
            }
            sum += val;
            queue.offer(val);
            return sum / queue.size();
        }
    }

}

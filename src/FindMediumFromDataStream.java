import java.util.Collections;
import java.util.PriorityQueue;

public class FindMediumFromDataStream {
    private PriorityQueue<Integer> low = null;
    private PriorityQueue<Integer> high = null;
    /** initialize your data structure here. */
    public FindMediumFromDataStream() {
        low = new PriorityQueue<Integer>(Collections.reverseOrder());
        high = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());

        if (low.size() < high.size()){
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() > high.size()){
            return (double) low.peek();
        } else {
            return (low.peek() + high.peek()) * 0.5;
        }
    }
}

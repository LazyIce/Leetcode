import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Flatten2DVector {
    Queue<Integer> queue;
    Iterator<Integer> iter;

    public Flatten2DVector(int[][] v) {
        queue = new LinkedList<>();
        for(int i=0; i<v.length; i++) {
            int[] inner = v[i];
            for(int j=0; j<inner.length; j++) {
                queue.add(inner[j]);
            }
        }
        iter = queue.iterator();
    }

    public int next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}

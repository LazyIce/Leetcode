import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class _251_Flatten2DVector {
    private Queue<Integer> queue;
    private Iterator<Integer> iter;

    public _251_Flatten2DVector(int[][] v) {
        queue = new LinkedList<>();
        for(int i = 0; i < v.length; i++) {
            int[] inner = v[i];
            for(int j = 0; j < inner.length; j++) {
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

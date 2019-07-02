import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class _281_ZigzagIterator {
    /**
     * time: O(n)
     * space: O(1)
     */
    LinkedList<Iterator> list;

    public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty())
            list.add(v1.iterator());
        if (!v2.isEmpty())
            list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.poll();
        int result = (Integer)poll.next();
        if (poll.hasNext()) {
            list.add(poll);
        }
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

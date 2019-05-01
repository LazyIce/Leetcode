import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    private Queue<Integer> queue;
    private boolean isOriginState = true;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (isOriginState){
            queue.offer(x);
        }else {
            int e = queue.poll();
            queue.offer(e);
            queue.offer(x);
            isOriginState = true;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (isOriginState){
            for (int i = 0; i < queue.size() - 1; i++) {
                int e = queue.poll();
                queue.offer(e);
            }
            return queue.poll();
        }
        isOriginState = true;
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        if (isOriginState){
            for (int i = 0; i < queue.size() - 1; i++) {
                int e = queue.poll();
                queue.offer(e);
            }
            isOriginState = false;
        }
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

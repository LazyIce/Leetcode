import java.util.Stack;

public class _232_ImplementQueueusingStacks {
    private Stack<Integer> inbuf;
    private Stack<Integer> outbuf;

    /** Initialize your data structure here. */
    public _232_ImplementQueueusingStacks() {
        inbuf = new Stack<Integer>();
        outbuf = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inbuf.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return outbuf.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outbuf.empty()) {
            while (!inbuf.empty()) {
                outbuf.push(inbuf.pop());
            }
        }
        return outbuf.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inbuf.empty() && outbuf.empty();
    }
}

import java.util.Stack;

public class _155_EasyStack {
    private int min;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public _155_EasyStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);   // keep the previous min
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

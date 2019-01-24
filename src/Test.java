import java.util.*;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(2);
        System.out.print(queue.peek());
    }
}

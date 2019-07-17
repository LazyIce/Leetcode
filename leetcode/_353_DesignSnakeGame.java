import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.LinkedList;

public class _353_DesignSnakeGame {
    class SnakeGame {
        private Set<Integer> set; // position
        private Deque<Integer> deque;
        private int score;
        private int foodIndex;
        private int width;
        private int height;
        private int[][] food;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            set = new HashSet<>();
            deque = new LinkedList<>();
            score = 0;
            foodIndex = 0;
            set.add(0);
            deque.offerLast(0);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            if (score == -1) {
                return -1;
            }

            int rowHead = deque.peekFirst() / width;
            int colHead = deque.peekFirst() % width;

            switch (direction) {
                case "U" : rowHead--;
                    break;
                case "D" : rowHead++;
                    break;
                case "L" : colHead--;
                    break;
                default : colHead++;
            }
            int head = rowHead * width + colHead;
            set.remove(deque.peekLast());
            if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
                return score = -1;
            }
            set.add(head);
            deque.offerFirst(head);
            if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
                foodIndex++;
                score++;
                set.add(deque.peekLast());
                return score;
            }
            deque.pollLast();
            return score;
        }
    }
}

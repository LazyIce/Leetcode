import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class _379_DesignPhoneDirectory {
    class PhoneDirectory {
        private Queue<Integer> queue;
        private Set<Integer> used;
        private int maxNumber;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            queue = new LinkedList<>();
            used = new HashSet<>();
            maxNumber = maxNumbers;
            for (int i = 0; i < maxNumbers; i++) {
                queue.offer(i);
            }
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            Integer number = queue.poll();
            if (number == null)
                return -1;
            used.add(number);
            return number;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            if (number >= maxNumber || number < 0)
                return false;
            return !used.contains(number);
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if (used.remove(number)) {
                queue.offer(number);
            }
        }
    }
}

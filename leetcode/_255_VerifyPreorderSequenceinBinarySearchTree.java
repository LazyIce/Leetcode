import java.util.Stack;

public class _255_VerifyPreorderSequenceinBinarySearchTree {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean verifyPreorder1(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            // get the min number in current tree
            while (!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }

        return true;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean verifyPreorder2(int[] preorder) {
        int min = Integer.MIN_VALUE, i = -1;
        for (int num : preorder) {
            if (num < min)
                return false;
            while (i >= 0 && num > preorder[i]) {
                min = preorder[i];
                i--;
            }
            i++;
            preorder[i] = num;
        }

        return true;
    }
}

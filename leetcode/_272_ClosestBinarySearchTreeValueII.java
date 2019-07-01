import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class _272_ClosestBinarySearchTreeValueII {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }

    public void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null)
            return;
        helper(res, root.left, target, k);
        if (res.size() == k) {
            if (Math.abs(target - root.val) < Math.abs(target - res.peek()))
                res.poll();
            else
                return;
        }
        res.add(root.val);
        helper(res, root.right, target, k);
    }

    /**
     * Iteration - two stacks
     * time: O(klogn)
     * space: O(n)
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Integer> precedessor = new Stack<>();
        Stack<Integer> successor = new Stack<>();
        getPredecessor(root, target, precedessor);
        getSuccessor(root, target, successor);
        // compare the last two elements in the predecessors and successors
        for (int i = 0; i < k; i++) {
            if (precedessor.isEmpty()) {
                res.add(successor.pop());
            } else if (successor.isEmpty()) {
                res.add(precedessor.pop());
            } else if (Math.abs((double)precedessor.peek() - target) < Math.abs((double)successor.peek() - target)) {
                res.add(precedessor.pop());
            } else {
                res.add(successor.pop());
            }
        }

        return res;
    }
    // inorder traversal to get all the predecessors of target
    public void getPredecessor(TreeNode root, double target, Stack<Integer> precedessor) {
        if (root == null)
            return;
        getPredecessor(root.left, target, precedessor);
        if (root.val > target)
            return;
        precedessor.push(root.val);
        getPredecessor(root.right, target, precedessor);
    }
    // inorder traversal to get all the successors of target
    public void getSuccessor(TreeNode root, double target, Stack<Integer> successor) {
        if (root == null)
            return;
        getSuccessor(root.right, target, successor);
        if (root.val <= target)
            return;
        successor.push(root.val);
        getSuccessor(root.left, target, successor);
    }
}

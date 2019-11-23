import java.util.Arrays;

public class CountOfSmallerNumbersBeforeSelf {
    public static void main(String[] args) {
        int[] arr = new int[] {13, 2, 4, 5, 12, 6};
        int[] res = countSmaller(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            root = insert(nums[i], root, res, i, 0);
        }
        return res;
    }

    public static Node insert(int num, Node node, int[] res, int i, int presum) {
        if (node == null) {
            node = new Node(num, 0);
            res[i] = presum;
        } else if (node.val == num) {
            node.dup++;
            res[i] = presum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, res, i, presum);
        } else {
            node.right
                    = insert(num, node.right, res, i, presum + node.sum + node.dup);
        }
        return node;
    }

    static class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

}

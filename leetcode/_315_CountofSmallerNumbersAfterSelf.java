import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {
    /**
     * Binary Indexed Tree
     * time: O(nlogn)
     * space: O(n)
     */
    private int[] BIT;

    public List<Integer> countSmaller1(int[] nums) {
        // nums: [5, 2, 6, 1]
        // copy: [1, 2, 5, 6]
        // rank(nums): [3, 2, 4, 1]
        // BIT:  [0, 1, 2, 1, 4]
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.binarySearch(copy, nums[i]) + 1;
        }
        BIT = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            res.add(getSum(nums[i] - 1));
            update(nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private int getSum(int idx) {
        int sum = 0;
        for (int i = idx; i >= 1; i -= i & (-i)) {
            sum += BIT[i];
        }
        return sum;
    }

    private void update(int idx) {
        for (int i = idx; i < BIT.length; i += i & (-i)) {
            BIT[i]++;
        }
    }

    /**
     * Segment Tree
     */
    public List<Integer> countSmaller2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (min < 0){
            for(int i = 0; i < nums.length;i++){
                nums[i] = nums[i] - min;
                max = Math.max(max, nums[i]);
            }
            min=0;
        }

        List<Integer> result = new ArrayList<>();
        SegmentTree tree = new SegmentTree(min, max, 0);

        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(0, tree.find(tree.root, nums[i] - 1));
            tree.add(tree.root, nums[i]);
        }

        return result;
    }

    class SegmentTreeNode {
        int start;
        int end;
        int count;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        public int mid() {
            return (end - start) / 2 + start;
        }
    }

    class SegmentTree {
        SegmentTreeNode root;

        public SegmentTree(int start, int end, int count) {
            root = build(start, end, count);
        }

        private SegmentTreeNode build(int start, int end, int count) {
            if (start > end) {
                return null;
            }

            if (start == end) {
                return new SegmentTreeNode(start, end, count);
            }

            SegmentTreeNode node = new SegmentTreeNode(start, end, count);
            node.left = build(start, node.mid(), count);
            node.right = build(node.mid() + 1, end, count);
            return node;
        }

        public int find(SegmentTreeNode node, int val) {
            if (node == null) {
                return 0;
            }
            if (node.end <= val) {
                return node.count;
            } else {
                if (val < node.mid()) {
                    return find(node.left, val);
                } else {
                    return find(node.left, val) + find(node.right, val);
                }
            }
        }

        public void add(SegmentTreeNode node, int val) {
            if (val > node.end || val < node.start) {
                return;
            }
            node.count++;
            if (node.start == node.end) {
                return;
            }

            if (val <= node.mid()){
                if(node.left == null){
                    node.left = new SegmentTreeNode(node.start, node.mid(), 0);
                }
                add(node.left, val);
            } else {
                if (node.right == null){
                    node.right = new SegmentTreeNode(node.mid() + 1, node.end, 0);
                }
                add(node.right, val);
            }
        }
    }

    /**
     * Binary Search Tree
     */
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller3(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}

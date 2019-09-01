import java.util.Map;
import java.util.HashMap;

public class _437_PathSumIII {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public int pathSum1(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumFrom(root, sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

    /**
     * time: O(n)
     * space: O(n)
     */
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);
    }

    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.val;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0);
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                + findPathSum(curr.right, sum, target, map);
        // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}

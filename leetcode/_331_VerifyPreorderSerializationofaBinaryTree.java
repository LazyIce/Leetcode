public class _331_VerifyPreorderSerializationofaBinaryTree {
    /**
     * time: O(n)
     * space: O(1)
     * Each node with value has two children nodes
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            diff--;
            if (diff < 0)
                return false;
            if (!node.equals("#"))
                diff += 2;
        }

        return diff == 0;
    }
}

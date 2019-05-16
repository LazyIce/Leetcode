import java.util.*;

public class BinaryTreePaths {
    // recursion
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root==null)
            return res;

        if (root.left==null && root.right==null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        for (String s: binaryTreePaths1(root.left)) {
            res.add(Integer.toString(root.val)+"->"+s);
        }
        for (String s: binaryTreePaths1(root.right)) {
            res.add(Integer.toString(root.val)+"->"+s);
        }

        return res;
    }

    //BFS - Queue
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<String>();
        Queue<TreeNode> qNode = new LinkedList<TreeNode>();
        Queue<String> qStr = new LinkedList<String>();

        if (root==null)
            return res;

        qNode.add(root);
        qStr.add("");

        while(!qNode.isEmpty()) {
            TreeNode curNode=qNode.remove();
            String curStr=qStr.remove();

            if (curNode.left==null && curNode.right==null)
                res.add(curStr+curNode.val);

            if (curNode.left!=null) {
                qNode.add(curNode.left);
                qStr.add(curStr+curNode.val+"->");
            }
            if (curNode.right!=null) {
                qNode.add(curNode.right);
                qStr.add(curStr+curNode.val+"->");
            }
        }

        return res;
    }

    //DFS - Stack
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> res = new ArrayList<String>();
        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<String> sStr = new Stack<String>();

        if(root==null)
            return res;

        sNode.push(root);
        sStr.push("");

        while(!sNode.isEmpty()) {
            TreeNode curNode=sNode.pop();
            String curStr=sStr.pop();

            if(curNode.left==null && curNode.right==null)
                res.add(curStr+curNode.val);

            if(curNode.left!=null) {
                sNode.push(curNode.left);
                sStr.push(curStr+curNode.val+"->");
            }

            if(curNode.right!=null) {
                sNode.push(curNode.right);
                sStr.push(curStr+curNode.val+"->");
            }
        }

        return res;
    }
}

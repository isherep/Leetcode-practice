package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversalFaster(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
        return res;
    }

    /* SLOWER */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        helper(cur, s, res);
        while (!s.isEmpty()) {
            cur = s.pop();
            System.out.println("cur popped " + cur.val);
            //res.add(cur.val);
            //s.push(cur.right);
            helper(cur, s, res);
            if (cur.left != null) {

                cur = cur.left;
            }
        }
        return res;
    }

    public void helper(TreeNode n, Stack<TreeNode> s, List<Integer> res) {

        while (n != null) {
            System.out.println("n " + n.val);
            res.add(n.val);
            if (n.right != null) {
                s.push(n.right);
            }
            n = n.left;
        }

    }

}

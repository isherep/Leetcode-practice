package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTSum {
    /* Recursive using inorder traversal */
    public int rangeSumBST(TreeNode root, int L, int R) {
        return sum(root, L, R, 0);
    }

    // use inorder traversal, or any other
    public int sum(TreeNode root, int L, int R, int sum) {
        if (root == null) return sum;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        // recurse left
        int sumLeft = sum(root.left, L, R, sum);
        // pass the sum from the left to recurse right
        // if you pass just sum, it will go back to original sum and will exclude left traversal accumulation
        int sumRight = sum(root.right, L, R, sumLeft);
        return sumRight;
    }

    /* Iterative inorder traversal using stack */
    public int rangeSumBSTStack(TreeNode root, int L, int R) {

        int sum = 0;
        if (root == null) return sum;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (cur.val >= L && cur.val <= R) {
                sum += cur.val;
            }
            cur = cur.right;
        }
        return sum;
    }

    /* Level Order Traversal */
    public int rangeSumBSTLevelOrder(TreeNode root, int L, int R) {

        int sum = 0;
        if (root == null) return sum;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val >= L && cur.val <= R) {
                sum += cur.val;
            }
            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }

        return sum;
    }

}

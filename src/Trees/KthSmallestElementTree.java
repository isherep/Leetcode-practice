package Trees;

import java.util.Stack;

public class KthSmallestElementTree {
    public int kthSmallest(TreeNode root, int k) {
        // find the Kth element from the stack using stack inorder traversal
        if (root == null) return 0;
        int counter = 0;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || counter < k) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            counter++;
            if (counter == k) {
                return cur.val;
            } else {
                // why does this doesn't throw exeption
                // in case if cur
                cur = cur.right;
                System.out.println("cur.right " + cur.right.val);
            }

        }
        return cur.val;
    }
}

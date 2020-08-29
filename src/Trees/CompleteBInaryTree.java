package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBInaryTree {
    public boolean isCompleteTree(TreeNode root) {

        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            // if seen a non null after null - return false
            if (curr != null && flag) return false;
            if (curr == null) flag = true;
                // only if cur is non null
            else {
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return true;
    }
}

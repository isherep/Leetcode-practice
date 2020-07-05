package BFS;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

// check if the BT tree is symetric
public class SymetricTree {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        while(q.size() >1){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left== null&& right == null) continue;
            if(right == null || left == null) return false;
            if(left.val !=right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}

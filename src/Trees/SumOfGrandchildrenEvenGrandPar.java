package Trees;

import java.util.HashSet;

public class SumOfGrandchildrenEvenGrandPar {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {

        // for each node with even value - check if it has grandchildren
        // if found even valued grandparent - call DFS to sum all of his children
        // need to mark which ones were visited.
        HashSet<TreeNode> set = new HashSet<>();
        if (root == null) return 0;
        DFS(root, set);
        return sum;
    }

    public void DFS(TreeNode node, HashSet<TreeNode> set) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null) {
                    sum += node.left.left.val;
                }
                if (node.left.right != null) {
                    sum += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    sum += node.right.left.val;
                }

                if (node.right.right != null) {
                    sum += node.right.right.val;
                }
            }
        } // end of checking if even
        DFS(node.left, set);
        DFS(node.right, set);
    }
}

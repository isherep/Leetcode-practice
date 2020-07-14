package Trees;

public class FlattenTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode cur = root;
        // oterate untill all left nodes processed
        while (cur != null) {
            while (cur.left != null) {
                // find the right leaf of the left subtree - attached left to it
                TreeNode rightLeaf = findRightLeaf(cur.left);
                // System.out.println("right leaf: " + rightLeaf.val);
                // save a subtree of right
                TreeNode rightSubTree = cur.right;
                // attached right subtree to the right leaf of left subtree
                rightLeaf.right = cur.right;
                // switch left and right
                cur.right = cur.left;
                cur.left = null;

            }
            // move to the right
            cur = cur.right;
        }

    }

    public TreeNode findRightLeaf(TreeNode root) {
        if (root.right == null) return root;
        //if(root.right == null && right.left != null) first
        return findRightLeaf(root.right);
    }
}

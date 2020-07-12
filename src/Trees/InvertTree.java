package Trees;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        // switch root.right and root.left
        if (root == null) return root;
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;

    }
}

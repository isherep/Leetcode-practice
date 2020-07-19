package Trees;

/* https://www.youtube.com/watch?v=kR5AxWHa9nc&feature=youtu.be */
public class ValidateBSTTree {
    public boolean isValidBST(TreeNode root) {
        Integer min = null;
        Integer max = null;
        if (root == null) return true;
        return isBST(root, min, max);
    }

    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}

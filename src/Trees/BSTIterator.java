package Trees;

import java.util.HashMap;
import java.util.Map;

public class BSTIterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    private TreeNode root;
    private TreeNode cur;
    private boolean start;
    private HashMap<TreeNode, TreeNode> parents;

    // every time I find leftmost node - I clean up old map
    // and fill it up with a new path,
    public BSTIterator(TreeNode root) {
        //initialized with the root node of a BST.
        this.root = root;
        this.cur = root;
        start = true;
        parents = new HashMap<>();
    }

    /**
     * @return the next smallest number
     */
    // returns inorder successor
    public int next() {
        for (Map.Entry<TreeNode, TreeNode> e : parents.entrySet()) {
            // System.out.println("child " + e.getKey().val + " parent " + e.getValue().val);
        }
        // case when it is first iteration - return start of inorder
        if (cur == root && start == true) {
            this.start = false;
            // return leftmoset - beginning of inorder traversal
            cur = leftMost(cur);
            return cur.val;
        } else {
            System.out.print("cur " + cur.val);
            // if there is left subtree -
            if (cur.right == null) {
                cur = parents.get(cur);
                return cur.val;
            } else {
                cur = leftMost(cur.right);
                return cur.val;
            }

        }
    }

    /**
     * @return whether we have a next smallest number
     */
    // no inorder succesor only when reached max - right leaf
    public boolean hasNext() {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        TreeNode cur1 = this.cur;
        TreeNode rl = rightestLeaf(root);

        System.out.println(rl.val);
        if (cur1 == rl) return false;
        else return true;

    }

    public TreeNode leftMost(TreeNode node) {
        parents.clear();

        while (node.left != null) {
            parents.put(node.left, node);
            node = node.left;
        }
        return node;
    }

    public TreeNode rightestLeaf(TreeNode node) {
        if (node.right == null) return node;
        return rightestLeaf(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}

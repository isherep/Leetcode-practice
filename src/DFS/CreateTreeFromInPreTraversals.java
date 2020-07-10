package DFS;

public class CreateTreeFromInPreTraversals {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        InOrder - left, root, right
        Preorder - root, left, right
        */
            // first node on the left is inorder[0]
            int rootIdxPre = 0;
            int rootNode = preorder[rootIdxPre];
            int inRootIdx = 0;
            // find the position of root node is in the inorder traversal
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootNode) {
                    inRootIdx = i;
                }
            }
            System.out.println(rootNode + ", " + " inRootIdx " + inRootIdx);
            int n = inorder.length;
            TreeNode root = helper(preorder, inorder, 0, n - 1);
            return root;
        }

        public TreeNode helper(int[] preorder, int[] inorder,
                               int left, int right) {

            // stop condition

            // while lo < hi:
            while (left < right) {
                TreeNode rootNode = new TreeNode(preorder[0]);
                int inRootIdx = 0;
                for (int i = 0; i < right; i++) {
                    if (inorder[i] == rootNode.val) {
                        inRootIdx = i;
                    }
                }
                System.out.println(rootNode + ", " + " inRootIdx " + inRootIdx);
                // int inRootIdx = 0;
                TreeNode root = new TreeNode(preorder[0]);
                // inRootIdx -1 - right index for left subtree
                root.left = helper(preorder, inorder, 0, inRootIdx - 1);
                // inRootIdx = left start for the right subtree
                int n = preorder.length;
                root.right = helper(preorder, inorder, inRootIdx + 1, n);

                return root;
            }

            return null;

        }
    }
}

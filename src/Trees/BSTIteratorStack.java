package Trees;

import java.util.Stack;

public class BSTIteratorStack {


        private TreeNode cur;
        private Stack<TreeNode> stack;

        public BSTIteratorStack(TreeNode root) {
            cur = root;
            stack = new Stack();
        }

        public boolean hasNext() {
            return cur != null || !stack.empty();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode next = stack.pop();
            cur = next.right;
            return next.val;
        }
}


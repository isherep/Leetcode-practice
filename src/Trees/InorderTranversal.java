package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTranversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root == null) return res;
        TreeNode cur = root;
        // first push all the left nodes into stack
        pushLeft(cur, s);
        // after left nodes ended - pop a stack, add to list,
        // and check if each popped node has right subtree.
        // if it does - move cur to it and repead adding all left to the stack.
        while(!s.isEmpty()){
            cur = s.pop();
            res.add(cur.val);
            if(cur.right != null){
                cur = cur.right;
                pushLeft(cur, s);
            }
        }
        return res;
    }
    // adds all the left nodes to the stack
    public void pushLeft(TreeNode n, Stack<TreeNode> s){
        while(n != null){
            s.push(n);
            n = n.left;
        }
    }
}

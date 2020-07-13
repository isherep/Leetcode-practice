package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        // if(p == null || q == null) return false;
        // iterative
        Queue<TreeNode> pQ = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();
        pQ.add(p);
        qQ.add(q);
        while (!pQ.isEmpty() && !qQ.isEmpty()) {
            TreeNode cur1 = pQ.poll();
            TreeNode cur2 = qQ.poll();
            if (cur1 != null && cur2 == null) return false;
            else if (cur2 != null && cur1 == null) return false;

            else {
                if (cur1 != null && cur2 != null) {
                    if (cur1.val != cur2.val) {
                        return false;
                    }
                    ;
                }
            }

            if (cur1 != null)
                pQ.add(cur1.left);
            if (cur1 != null)
                pQ.add(cur1.right);
            if (cur2 != null)
                qQ.add(cur2.left);
            if (cur2 != null)
                qQ.add(cur2.right);
        }

        // if after this one queue is not empty - return false
        if (!pQ.isEmpty() || !qQ.isEmpty()) return false;

        return true;


    }
}

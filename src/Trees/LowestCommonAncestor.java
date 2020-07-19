package Trees;

import java.util.*;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        // if one of the nodes if found - return them
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        // create a map of all ancestors
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                // this works only if values in the tree are uniqueu
                // otherwise the will be colisions in the tree
                TreeNode cur = queue.poll();
                i++;
                if (cur.left != null) {
                    map.put(cur.left, cur);
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    map.put(cur.right, cur);
                    queue.add(cur.right);
                }
            }
        }
        // now put all the P ancestors into the set
        Set<TreeNode> setP = new HashSet<TreeNode>();

        TreeNode curP = map.get(p);
        // don't forget to ad p itself to the set and p can be
        // common ansestor in the case like [1,2], p=1,q=2
        setP.add(curP);
        setP.add(p);
        while (curP != null) {
            System.out.println("curP " + curP.val);
            setP.add(curP);
            curP = map.get(curP);
        }
        // check if the set of p ancestors contains q
        if (setP.contains(q)) {
            return q;
        }
        // now check if that set contains any of q ancestors
        TreeNode curQ = map.get(q);
        while (curQ != null) {
            System.out.println("curQ " + curQ.val);
            if (setP.contains(curQ) || setP.contains(q)) {
                return curQ;
            }
            curQ = map.get(curQ);

        }

        return null;

    }
}

package DFS;

public class isSubtreeOfAnotherTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) {return false;}
        else if(s.val == t.val && matchTree(s, t)){ return true;}
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean matchTree(TreeNode r1, TreeNode r2){
        // if reached the end of the trees
        if(r1 == null && r2 == null){
            return true;
        } else if(r1 == null || r2 == null){
            return false;
        } else if(r1.val != r2.val){
            return false;
        } else {
            // match left and right children
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }
}

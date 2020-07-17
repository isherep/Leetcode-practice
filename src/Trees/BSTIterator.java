package Trees;

import java.util.HashMap;
import java.util.Map;

public class BSTIterator {
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
            System.out.println("key " + e.getKey().val + " parent " + e.getValue().val);
        }

        // FIRST ITERATION - return start of inorder
        if (cur == root && start == true) {
            this.start = false;
            // return leftmoset - beginning of inorder traversal
            cur = leftMost(cur);
            
            return cur.val;
        } else {
            System.out.println("cur " + cur.val);

            //  IF NO RIGHT SUBTREE- go up to one of the ANCESTORS
            if (cur.right == null) {
                // move current up untill cur != parents.get(cur).left
                while (cur != parents.get(cur).left) { //parents.containsKey(cur)){
                    System.out.println("parents.get(cur): " + parents.get(cur).val);
                    cur = parents.get(cur);
                }
                System.out.println("parents.get(cur): " + parents.get(cur).val);
                cur = parents.get(cur);
                return cur.val;

                // IF THE RIGHT SUBTREE PRESENT
            } else {
                cur = leftMost(cur.right);
                return cur.val;
            }
        }
        //return cur.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    // no inorder succesor only when reached max - right leaf
    public boolean hasNext() {
        // check if it is a starting point
        // check if it has a left subtree
        if (root != null && this.cur == root && start == true) {
            return true;
        }
        // check if it has a right subtree
        else if (cur.right != null) {
            // check for ancestors            
            return true;
        } else if (cur == rightestLeaf(root)) {
            System.out.println("cur " + cur.val + "Rightest leaf " + rightestLeaf(root).val);
            return false;

        } else {
            if (parents.containsKey(cur)) {
                return true;
            } else {
                return false;
            }
        }
        //return false;
    }

    public TreeNode leftMost(TreeNode node) {
        // parents.clear();     
         while(node.left!= null){
             parents.put(node.left, node);
             System.out.println("node " + node.val);
             if(node != null && node.right != null ){
                 parents.put(node.right, node);
             }
              node = node.left;
             //System.out.println("node " + node.val + ", node right " + node.right.val);
            }
            return node;
            }

    public TreeNode rightestLeaf(TreeNode node) {
        if (node.right == null) return node;
        return rightestLeaf(node.right);
    }
    
    public static void main(String[] args){
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    root.right = new TreeNode(4);
    
    BSTIterator iterator = new BSTIterator(root);
    
    iterator.hasNext(); // true
    iterator.next();    // return 1
    
    iterator.hasNext(); // return true
    iterator.next();    // return 2
    
    iterator.hasNext(); // return true
    iterator.next();
    }
}
  

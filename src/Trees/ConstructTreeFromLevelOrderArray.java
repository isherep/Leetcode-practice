package Trees;

public class ConstructTreeFromLevelOrderArray {
   // Time Complexity: O(n), where n is the total number of nodes in the tree. 
    public static TreeNode construct(int[] arr) {
       // TreeNode root =  arr[0];
        TreeNode root = null;
        root = insertLevelOrder(arr, root, 0);

        return root;
    }

    // Function to insert nodes in level order
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root,
                                     int i) {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }
    
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }


    public static void main(String[] args) {
        //         0     1  2    3   4  5
        //arr[] = {1,    2, 3,    4,  5, 6}
        // Tree t2 = new Tree();
        //System.out.print(t2.root);
        
        int arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        TreeNode root = construct(arr);
        inOrder(root);

    }

}

package Trees;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/create-a-tree-in-level-order/
//https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
// Assumption - Complete Tree Only
// This method works for BST only if it is complete, but if it missing right or left nodes
// will not work
public class ConstructTreeFromLevelOrderArray {

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

    public static TreeNode constructIterative(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 0; i < arr.length; i++) {
            //System.out.print(i + ", ");
            TreeNode cur = q.poll();
            // System.out.print(cur.data + ", ");
            if (2 * i + 1 < arr.length) {
                cur.left = new TreeNode(arr[2 * i + 1]);
                q.add(cur.left);
            }

            if (2 * i + 2 < arr.length) {
                cur.right = new TreeNode(arr[2 * i + 2]);
                q.add(cur.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        int[] arr1 = {10, 20, 30, 40, 50, 60};
        // root, root.left, root.right, next level nodes
        int[] arrBST = {7, 4, 12, 3, 6, 8, 13, 1, 5, 10}; // 8 4 2 5 1 6 3 7
        // {7, 4, 12, 3, 6, 8, 1, 5, 10}
        TreeNode root = construct(arrBST);
        inOrder(root);
        // assert value >= 20 : " Underweight";
        // expected 6 4 6 2 5 1 6 3 6 
        //          6 4 6 2 5 1 6 3 6  


    }

}

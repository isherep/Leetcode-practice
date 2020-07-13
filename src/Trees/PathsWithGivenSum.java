package Trees;

import java.util.ArrayList;

/*
  Start from the root and branch left and right, computing the sum thus far on each path.
  When we find the sum, we print the current path.
  Note that we don’t stop just because we found the sum. Why?
  Because we could have the following path (assume we are looking for the sum
  5): 2 + 3 + –4 + 3 + 1 + 2. If we stopped once we hit 2 + 3,
  we’d miss several paths (2 + 3 + -4 + 3 + 1 and 3 + -4 + 3 + 1 + 2).
  So, we keep going along every possible path.
  Now, what if the path can start anywhere?

  In that case, we make a small modification.

  On every node, we look “up” to see if we’ve found the sum.
 That is—rather than asking “does this node start a path with the sum?,”
 we ask “does this node complete a path with the sum?”
 */
// Java program to print all paths with sum k.
public class PathsWithGivenSum {

    // binary tree node
    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    ;

    //utility function to print contents of
//a vector from index i to it's end
    static void printPath(ArrayList<Integer> list, int i) {
        for (int j = i; j < list.size(); j++)
            System.out.print(list.get(j) + " ");
        System.out.println();
    }


    static ArrayList<Integer> path = new ArrayList<Integer>();

    // This function prints all paths that have sum k
    static void printKPathUtil(Node root, int k) {
        // when reached end of path - return, check path sum from end and print path
        if (root == null)
            return;
        // add current node to the path
        path.add(root.data);
        // check if there's any k sum path
        // in the left sub-tree.
        printKPathUtil(root.left, k);

        // check if there's any k sum path
        // in the right sub-tree.
        printKPathUtil(root.right, k);
        // check if there's any k sum path that
        // terminates at this node
        // Traverse the entire path as
        // there can be negative elements too
        int curSum = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            curSum += path.get(j);

            // If path sum is k, print the path
            if (curSum == k)
                printPath(path, j);
        }

        // Remove the current element from the path
        path.remove(path.size() - 1);
    }

    // A wrapper over printKPathUtil()
    static void printKPath(Node root, int k) {
        path = new ArrayList<Integer>();
        printKPathUtil(root, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(2);


    }
}


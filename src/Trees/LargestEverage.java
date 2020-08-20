package Trees;

import java.util.ArrayList;

/**
 * Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
 * A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 20
 * /   \
 * 12     18
 * /  |  \   / \
 * 11   2   3 15  8
 * <p>
 * Output: 18
 * Explanation:
 * There are 3 nodes which have children in this tree:
 * 12 => (11 + 2 + 3 + 12) / 4 = 7
 * 18 => (18 + 15 + 8) / 3 = 13.67
 * 20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125
 * <p>
 * 18 has the maximum average so output 18.
 */
class TreeNode1 {
    int val;
    ArrayList<TreeNode1> children;

    public TreeNode1(int val){
        this.val = val;
        children = new ArrayList<>();
    }
}

public class LargestEverage {
    /*

find the sum of values and the number of nodes for every sub-tre

 find the sum of values and the number of nodes for a sub-tree given the sum of values and the number of nodes of it's left and right sub-trees
     Use depth first search to recursively find the solution for the children of a node then use their solutions to compute the current node's solution.
     */

    static double max = Integer.MIN_VALUE;
    static  TreeNode1  maxNode = null;

    public static TreeNode1 maximumAverageSubtree(TreeNode1 root) {
        if (root == null) return null;
       double[] maxes = helper(root);
       System.out.println(maxes[0] + ", " + maxes[1]);
        return maxNode;
    }

    private static double[] helper(TreeNode1 root) {
        // cur sum on left and cur sum on right
        if (root == null) return new double[]{0, 0};
        // initialize curTotal and count to the root one
        double curTotal = root.val;
        double count = 1;
        // for each child - call recursively
        for (TreeNode1 child : root.children) {
            // get the result of sum and everage for each child
            double[] cur = helper(child);
            // add their results to cur
            curTotal += cur[0];
            count += cur[1];
        }
        // calculate the everage
        double avg = curTotal / count;
        // at least one node in the tree
        if (count > 1 && avg > max) { //taking "at least 1 child" into account
            max = avg;
            maxNode = root;
        }
        // return the cur total and count for the subtree
        return new double[]{curTotal, count};
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(20);
        root.children = new ArrayList<>(2);

        root.children.add(new TreeNode1(12));
        root.children.add(new TreeNode1(18));

        root.children.get(0).children.add(new TreeNode1(11));
        root.children.get(0).children.add(new TreeNode1(2));
        root.children.get(0).children.add(new TreeNode1(3));

        root.children.get(1).children.add(new TreeNode1(15));
        root.children.get(1).children.add(new TreeNode1(8));

        System.out.println(maximumAverageSubtree(root).val);


    }

}

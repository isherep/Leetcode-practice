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

public class PathsWithGivenSum {

    public void findSum(TreeNode head, int sum, ArrayList<Integer> buffer,
                        int level) {
        if (head == null) return;
        int tmp = sum;
        buffer.add(head.val);
        for (int i = level; i >= 0; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) print(buffer, i, level);
        }
        ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
        findSum(head.left, sum, c1, level + 1);
        findSum(head.right, sum, c2, level + 1);
    }

    public void print(ArrayList<Integer> buffer, int level, int i2) {
        for (int i = level; i <= i2; i++) {
            System.out.print(buffer.get(i) + " ");
        }
        System.out.println();
    }
}


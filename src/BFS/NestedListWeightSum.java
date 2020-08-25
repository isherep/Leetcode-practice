package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * <p>
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class NestedListWeightSum {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     */
    interface NestedInteger {
//          // Constructor initializes an empty nested list.
//          public NestedInteger();
//
//          // Constructor initializes a single integer.
//          public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {

        Queue<NestedInteger> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int level = 1;
        if (nestedList == null) return 0;
        for (NestedInteger list : nestedList) {
            // check if the element is an integer
            if (list.isInteger()) {
                sum += list.getInteger() * level;
            } else {
                q.add(list);
            }
        }
        level++;
        // my queue loks like [1,1], [1,1]
        System.out.println(q.size());
        while (!q.isEmpty()) {
            int size = q.size();
            int i = 0;
            while (i < size) {
                NestedInteger cur = q.poll();
                System.out.println(cur);
                List<NestedInteger> inside = cur.getList();
                // check each element of the list :
                // add integers to map and lists to the queue
                for (NestedInteger list : inside) {
                    if (list.isInteger()) {
                        // instead of adding to the map - multiply
                        sum += list.getInteger() * level;
                    } else {
                        q.add(list);
                    }
                }
                i++;
            }
            level++;
        }
        return sum;
    }
}

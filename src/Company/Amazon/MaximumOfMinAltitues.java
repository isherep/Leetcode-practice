package Company.Amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.
 * <p>
 * Don't include the first or final entry. You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[5, 1],
 * [4, 5]]
 * <p>
 * Output: 4
 * Explanation:
 * Possible paths:
 * 5 → 1 → 5 => min value is 1
 * 5 → 4 → 5 => min value is 4
 * Return the max value among minimum values => max(4, 1) = 4.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * [[1, 2, 3]
 * [4, 5, 1]]
 * <p>
 * Output: 4
 * Explanation:
 * Possible paths:
 * 1-> 2 -> 3 -> 1
 * 1-> 2 -> 5 -> 1
 * 1-> 4 -> 5 -> 1
 * So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
 * Return the max of that, so 4.
 */
public class MaximumOfMinAltitues {

    private static List<PriorityQueue<Integer>> res;
    // find all path
    // find the minimum value in each path using heap
    // select the maximum value from each min
    public static int maxScore(int[][] matrix) {
        List<PriorityQueue<Integer>> routes = getAllPath(matrix);
        int max = Integer.MIN_VALUE;
        // don't include the first and final entry
        for (PriorityQueue<Integer> path : routes) {
            int cur = path.poll();
            // System.out.println(cur);
            if (cur > max) max = cur;
        }
        return max;
    }

    public static List<PriorityQueue<Integer>> getAllPath(int[][] matrix) {
        res = new LinkedList<>();
        // create a first route and put top left element in it
        LinkedList<Integer> route = new LinkedList<>();
        route.add(matrix[0][0]);
        // call recursive method to generate paths down
        generatePath(1, 0, route, matrix);
        // and on the right
        generatePath(0, 1, route, matrix);
        return res;
    }

    public static void generatePath(int i, int j, List<Integer> path, int[][] matrix) {
        // add current element to the matrix
        path.add(matrix[i][j]);
        // if matrix reaches the last row and column(right bottom corner )
        // add the priority queue created based on the path list.
        // it will keep the score of each path as the top element in the heap
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            // do not include first and last element in the arrayList
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int k = 1; k < path.size() - 1; k++) {
                q.add(path.get(k));
            }
            //res.add(new PriorityQueue<>(path));
            res.add(q);
            // backtrack one element
            path.remove(path.size() - 1);
            return;
        }
        // if there is room down the way - recurse down
        if (i < matrix.length - 1) {
            generatePath(i + 1, j, path, matrix);
        }
        // if there is room to the right - recurse to the right
        if (j < matrix[i].length - 1) {
            generatePath(i, j + 1, path, matrix);
        }
        // remove last element
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1}, {4, 5}};
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 1}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(getAllPath(matrix));
        System.out.println(getAllPath(matrix1)); // [1-> 2 -> 3 -> 1], [1-> 2 -> 5 -> 1], [1-> 4 -> 5 -> 1]
        System.out.println(getAllPath(matrix2));
        List<PriorityQueue<Integer>> path = getAllPath(matrix2);
        // print all the paths
        for (PriorityQueue<Integer> l : path) {
            System.out.println(l);
        }
        System.out.println("max score: " + maxScore(matrix));
        System.out.println("max score in 2: " + maxScore(matrix1));
        System.out.println("max score in 3: " + maxScore(matrix2));

    }
}

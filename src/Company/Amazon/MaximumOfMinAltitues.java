package Company.Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    // private static int[][] matrix = new int[2][2];
    private static List<List<Integer>> res;
    // find all path
    // find the minimum value in each path
    // select the maximum value from each min


    // put treemap - m
    public static List<List<Integer>> getAllPath(int[][] matrix) {
        res = new LinkedList<>();
        // create a first route and put top left element in it
        LinkedList<Integer> route = new LinkedList<>();
        route.add(matrix[0][0]);
        // call recursive method to start generating paths down
        generatePath(1, 0, route, matrix);
        generatePath(0, 1, route, matrix);
        return res;
    }

    public static void generatePath(int i, int j, List<Integer> path, int[][] matrix) {
        // if beyong the  matrix - add to the res list
        path.add(matrix[i][j]);
        // if matrix reachec the last row and column(right bottom corner )
        // add the clone of path list to the result list, and return
        // do not add path, because it will change, add a copy of it
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            // path.add(matrix[i][j]);
            res.add(new ArrayList<>(path));
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
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1}, {4, 5}};
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 1}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(getAllPath(matrix));
        System.out.println(getAllPath(matrix1)); // [1-> 2 -> 3 -> 1], [1-> 2 -> 5 -> 1], [1-> 4 -> 5 -> 1]
        System.out.println(getAllPath(matrix2));
        List<List<Integer>> path = getAllPath(matrix2);

        for (List<Integer> l : path) {
            System.out.println(l);
        }
        // testing for error - if any elements got two times in the path
        System.out.println("oversized ");
        for (List<Integer> l : path) {
            if (l.size() > 6) {
                System.out.println(l);
            }
        }
    }
}

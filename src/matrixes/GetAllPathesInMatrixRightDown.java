package matrixes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetAllPathesInMatrixRightDown {
    private static List<List<Integer>> res;

    public static List<List<Integer>> getAllPath(int[][] matrix) {
        res = new LinkedList<>();
        // create a first route and put top left element in it
        LinkedList<Integer> route = new LinkedList<>();
        route.add(matrix[0][0]);
        // call recursive method to start generating paths down
        generatePath(1, 0, route, matrix);
        // and on the right
        generatePath(0, 1, route, matrix);
        return res;
    }

    public static void generatePath(int i, int j, List<Integer> path, int[][] matrix) {
        // add current element to the matrix
        path.add(matrix[i][j]);
        // if matrix reachec the last row and column(right bottom corner )
        // add the clone of path list to the result list, and return
        // do not add path, because it will change, add a copy of it
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
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
        // remove last element
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1}, {4, 5}};
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 1}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        // System.out.println(getAllPath(matrix));
        System.out.println(getAllPath(matrix1)); // [1-> 2 -> 3 -> 1], [1-> 2 -> 5 -> 1], [1-> 4 -> 5 -> 1]
        //System.out.println(getAllPath(matrix2));
        List<List<Integer>> path = getAllPath(matrix2);

        for (List<Integer> l : path) {
            if (l.size() == 6) {
                System.out.println(l);
            }
        }
        System.out.println("oversized ");
        for (List<Integer> l : path) {
            if (l.size() > 6) {
                System.out.println(l);
            }
        }
    }
}

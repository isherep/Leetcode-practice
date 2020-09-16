package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ReconstructQueueByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 1) {
            return new int[][]{};
        }

        int[][] res = new int[people.length][2];


        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], people[i]);

        //int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);
        for (int[] p : res) {
            System.out.print(p[0] + "=" + p[1] + ", ");

        }
    }
}

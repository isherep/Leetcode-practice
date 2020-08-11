package IntervalProblems;

import java.util.LinkedList;

/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.
 */
public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // sorted order
        LinkedList<int[]> resList = new LinkedList<>();
        int i = 0;
        int j = 0;
        // edge case
        if (A == null || B == null) {
            return new int[][]{};
        }
        // using two pointers to iterate over different arrrays
        while (i < A.length && j < B.length) {
            if (A[i][1] >= B[j][0] && A[i][0] <= B[j][0]) {
                // find their intersection end
                int start = B[j][0];
                // select which one ends first
                int end = A[i][1] <= B[j][1] ? A[i][1] : B[j][1];
                resList.add(new int[]{start, end});
                // now find which pointer to increment
            }
            if (A[i][0] <= B[j][1] && A[i][0] > B[j][0]) {
                int start = A[i][0];
                // select which one ends faster
                int end = B[j][1] <= A[i][1] ? B[j][1] : A[i][1];
                resList.add(new int[]{start, end});
            }
            // if A ends before B - move to next interval in A
            if (A[i][1] <= B[j][1]) {
                i++;
                // if B ends before A - move to next interval in B
            } else if (A[i][1] > B[j][1]) {
                // do nothing, or increment j
                j++;
            } else {
                i++;
                j++;
            }
        }
        return convert(resList);
    }

    // convert linkedlist to array
    public int[][] convert(LinkedList<int[]> list) {
        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] arr : list) {
            res[i] = arr;
            i++;
        }
        return res;
    }
}

package Company.Amazon;

/*

  Let's call an array A a mountain if the following properties hold:

    A.length >= 3
    There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]

    Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

    Example 1:

    Input: [0,1,0]
    Output: 1

    Example 2:

    Input: [0,2,1,0]
    Output: 1
 */
public class PeakMountain {
    public int peakIndexInMountainArray(int[] A) {
        return helper(A, 0, A.length - 1);
    }


    public int helper(int[] A, int lo, int hi) {
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            if (A[mid - 1] <= A[mid] && A[mid] >= A[mid + 1]) {

                return mid;
            } else {
                // two cases - if left violates or right
                if (A[mid - 1] > A[mid]) {
                    return helper(A, lo, mid - 1);
                }

                if (A[mid] < A[mid + 1]) {
                    return helper(A, mid + 1, hi);
                }
            }
        }
        return -1;
    }
}

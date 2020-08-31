package BinarySearch;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 *
 *
 * Constraints:
 *
 *     0 <= nums.length <= 10^5
 *     -10^9 <= nums[i] <= 10^9
 *     nums is a non decreasing array.
 *     -10^9 <= target <= 10^9
 */
public class BinarySearchWithDupl {
    public int[] searchRange(int[] A, int target) {
        int start = findPosition(A, target, false);
        int end = findPosition(A, target, true);
        return new int[]{start, end};
    }

    private int findPosition(int[] A, int target, boolean isLast) {
        int low = 0, high = A.length-1, index = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(isLast){
                if (A[mid] <= target) low = mid + 1;
                else high = mid-1;
            } else{
                if (A[mid] < target) low = mid + 1;
                else high = mid-1;
            }
            if(A[mid] == target) index = mid; /** update index */
        }
        return index;
    }
}

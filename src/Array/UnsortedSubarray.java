package Array;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * Note:
 * <p>
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 * <p>
 * Brute - Force - select each subarray, sort it and check if it matches a sorted clone
 */
public class UnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[] nums1 = nums.clone();
        Arrays.sort(nums1);
        // if cloned arra is already sorted
        if (nums == nums1) return 0;
        int start = 0;
        for (int i = 0; i < nums1.length && i < nums.length; i++) {
            if (nums[i] != nums1[i]) {
                start = i;
                break;
            }
        }
        int end = start;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums[i] != nums1[i]) {
                end = i;
                break;
            }
        }
        return start == end ? 0 : end - start + 1;

    }
}

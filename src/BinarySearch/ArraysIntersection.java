package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysIntersection {
    // find the join intersection of two arrays

    /**
     * *******Slow method********
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[]{};
        }
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }
        // iterate over nums2 - if n is in set - increment count
        // when count is known - create an array and iterate again adding toarra
        // or add to a linked list
        for (int n : nums2) {
            if (set.contains(n)) {
                res.add(n);
            }
        }
        int[] resInt = res.stream().mapToInt(i -> i).toArray();

        return resInt;
    }

    /******* 2 SETS - RETAIN ALL method
     * O(m + N)
     */
    public int[] intersectionSets(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[]{};
        }
        Set<Integer> s1 = new HashSet<>();
        for (int n : nums1) {
            s1.add(n);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int n : nums2) {
            s2.add(n);
        }

        s1.retainAll(s2);
        int[] res = new int[s1.size()];
        int j = 0;
        for (int i : s1) {
            res[j++] = i;
        }
        return res;
    }

    /*
    *****BEST SOLUTION *****
    *
    * "What if nums1's size is small compared to nums2's size? Which algorithm is better?",
    * Sort the shorter one.
    *
    * which requires binary search.
        This is a Facebook interview question.
        They ask for the intersection, which has a trivial solution using a hash or a set.

        Then they ask you to solve it under these constraints:
        O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).

        * You are told the lists are sorted.

        Cases to take into consideration include:
        duplicates, negative values, single value lists, 0's, and empty list arguments.
        Other considerations might include
        sparse arrays.
     */

    /******Binary Search - not much FASTER ***********/
    public int[] intersectionB(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[]{};
        }
        // sort 2 arrays [1,1,2,2],
        // [1,2]
        // [4,5,9]
        // [4,4,8,9,9]
        // Set<Integer> res = new HashSet<>();
        int count = 0;
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            if (i == 0 && binS(nums2, nums1[i])) {
                count++;
            }
            if (i != 0 && nums1[i] != nums1[i - 1] && binS(nums2, nums1[i])) {
                count++;
                //res.add(n);
            }
        }
        int[] res = new int[count];
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i == 0 && binS(nums2, nums1[i])) {
                res[j] = nums1[i];
                j++;
            }
            if (i != 0 && nums1[i] != nums1[i - 1] && binS(nums2, nums1[i])) {
                res[j] = nums1[i];
                j++;
            }
        }
        return res;
        // use binary search to find if 2nd array contains the number
    }

    public boolean binS(int[] arr, int target) {
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == target) return true;
            if (target < arr[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }

}

package Company.Amazon;

import java.util.HashSet;

/**
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.
 *
 * Example 1:
 *
 * Input: nums = [1, 1, 2, 45, 46, 46], target = 47
 * Output: 2
 * Explanation:
 * 1 + 46 = 47
 * 2 + 45 = 47
 *
 * Example 2:
 *
 * Input: nums = [1, 1], target = 2
 * Output: 1
 * Explanation:
 * 1 + 1 = 2
 *
 * Example 3:
 *
 * Input: nums = [1, 5, 1, 5], target = 6
 * Output: 1
 * Explanation:
 * [1, 5] and [5, 1] are considered the same.
 *
 * Related problems:
 *
 *     https://leetcode.com/problems/two-sum
 *     https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 */
public class UniqueuPairs {

    public static int uniquePairs1(int[] nums, int target) {
        int count =0;
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        // no need to map because we don't need to know indexes
        // for each number is nums and if num is not seen - check if set contains tar-um
        // if it does - incremetn count
        for(int num: nums){
            if(!seen.contains(num) && set.contains(target-num)){
                count++;

            }
            if(seen.contains(num) && target-num == num){
                count++;
            }
            seen.add(num);
            set.add(num);
        }

        return count;
    }


    public static void main(String[] args){
        int[] test1 = {1, 1, 2, 45, 46, 46};
        System.out.println(uniquePairs1(test1, 47)); // 2
        int[] test2 = {1,1};
        System.out.println(uniquePairs1(test2, 2)); // 1
        int[] test3 = {1,5,1,5};
        System.out.println(uniquePairs1(test3, 6)); //1
        int[] test4 = {};
        System.out.println(uniquePairs1(test4, 0)); // 0
        int[] test5 = {3,7};
        System.out.println(uniquePairs1(test5,3)); // 0


    }








//    public static int uniquePairs(int[] nums, int target){
//        Set<Integer> set = new HashSet<Integer>();
//        Set<Integer> seen = new HashSet<Integer>();
//        int count = 0;
//        for(int num : nums){
//            if(set.contains(target-num) && !seen.contains(num)){
//                count++;
//                seen.add(target-num);
//                seen.add(num);
//            }
//            else if(!set.contains(num)){
//                set.add(num);
//            }
//
//        }
//        return count;
//    }
}

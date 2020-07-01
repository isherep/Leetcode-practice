package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplNumber1toN {
    /*
        n = 5, 1,2.3,3,4,5
        Sort the array - the duplicates will be next to each other
        Time O(n + Nlogn)
    */
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for(int i = 0; i< nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    public int findNoSort(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    /**
     * My understanding of this algo is that:
     * [1,3,4,2,2] -> [
     * you perceive the indices as the values.
     * Then count the number of values lesser than the mid
     * If the if the count is lesser than mid, we assume the duplicate number should be on the higher side of the number scale.
     * so we make low = mid + 1
     * else we assume the duplicate number should be on the lower end of the number scale.
     * so we make high = mid - 1
     *
     * We continue until low <=hight no longer holds true.
     *
     * No, it doesn't need to be sorted.
     * Variables low and high indicate the values in the array, not the index.
     *
     */
    public int findDuplicateBST(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}

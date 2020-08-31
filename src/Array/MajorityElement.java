package Array;

import java.util.Arrays;

public class MajorityElement {
    // sort elements first
    public int majorityElementSorting(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int count = 1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return nums[0];
    }
}

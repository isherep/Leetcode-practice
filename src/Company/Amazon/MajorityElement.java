package Company.Amazon;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 0) return 0;
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // two cases: if cur element == majority - count++
            // if count = 0 - asign marjority to cur
            // else count--;
            if (nums[i] == majority) {
                count++;
            } else if (count == 0) {
                majority = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return majority;
    }

}

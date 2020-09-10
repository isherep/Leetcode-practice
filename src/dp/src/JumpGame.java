public class JumpGame {
    public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }

    // returns last possible position of a jump
    public boolean helper(int[] nums, int start) {
        if (start == nums.length - 1) {
            return true;
        }
        int steps = nums[start];
        int furthest = Math.min(start + steps, nums.length - 1);
        // from start use every position until the number if steps reached
        for (int i = start + 1; i <= furthest; i++) {
            if (helper(nums, i)) {
                return true;
            }
        }
        return false;
    }
}

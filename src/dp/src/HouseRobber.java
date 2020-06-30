public class HouseRobber {

    /***********RECURSIVE*******************/
/*

    The trick is the dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]) statement
    (Phase of Transfer Function).

    Statemet 	Description
    dp[i - 2] + nums[i] 	Rob
    dp[i - 1]) 	No Rob
 */
    public int rob1(int[] nums) {
        for (int i = 2; i < nums.length; i++)
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        return nums[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        //Initialize an arrays to store the money
        int[] dp = new int[nums.length];

        //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
        //so initialize two nums at first.
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //Using Dynamic Programming to mark the max money in loop.
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
/*
 Recursive (top-down)
 */
    public int rob4(int[] nums) {
        return rob5(nums, nums.length - 1);
    }
    private int rob5(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob5(nums, i - 2) + nums[i], rob5(nums, i - 1));
    }
}

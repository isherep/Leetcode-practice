public class NumberOfWaysToReactStairs {
    /*
    https://www.youtube.com/watch?v=UyDyc6yV1iQ&feature=youtu.be
    See the recursion desicion tree - it explains that we need a solution if we take :
    - 2 steps as fist step
    - 1 step as the first step


     1. 1 step + 1 step + 1 step + 1 step
     2. 2 steps + 2 steps
     3. 2 steps + 1 step + 1 step
     4. 1 step + 1 step + 2 steps
     5. 1 step + 2 steps+ 1 step
     S   Wys   Cur   Pre  Inc
     3 - 3       3 - 2  = 1
     4 - 5       5 - 3  = 2
     5 - 8       8 - 5  = 3
     6 - 13      13 - 8 = 5
     7 - 21      21 - 13= 8
     8 - 34      34 - 21= 13
     // Fibonacci sequence???
     [1, 2, 3, 5, 8, 13, 21, 34]
     [  1  1  2  3   5  8   13  ]
     5 steps:
     7 ways to get to 4.

     One can reach ithi^{th}ith step in one of the two ways:

 Taking a single step from (i−1)th(i-1)^{th}(i−1)th step.

 Taking a step of 222 from (i−2)th(i-2)^{th}(i−2)th step.

So, the total number of ways to reach ithi^{th}ith is equal to sum of ways of reaching (i−1)th(i-1)^{th}(i−1)th step and ways of reaching (i−2)th(i-2)^{th}(i−2)th step.

Let dp[i]dp[i]dp[i] denotes the number of ways to reach on ithi^{th}ith step:

dp[i]=dp[i−1]+dp[i−2] dp[i]=dp[i-1]+dp[i-2] dp[i]=dp[i−1]+dp[i−2]
 */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}

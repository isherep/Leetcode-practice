public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        // Arrays.fill(dp, max);
        dp[0] = 0;
        /*Before calculating F(i)F(i)F(i), we have to compute all minimum counts for amounts up to iii. On each iteration iii of the algorithm F(i)F(i)F(i) is computed as min⁡j=0…n−1F(i−cj)+1\min_{j=0 \ldots n-1}{F(i -c_j)} + 1minj=0…n−1​F(i−cj​)+1*/
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    //                    amount - cur_coint_val +1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // dp [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]
        for(int i = 0; i< dp.length; i++){
            System.out.print(dp[i] + ", ");
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
 // faster
 public int coinChangeF(int[] coins, int amount) {
     int[] dp = new int[amount + 1];
     for (int i=1; i < dp.length; i++) {
         dp[i] = dp.length;
         for (int j=0; j < coins.length; j++) {
             if (i >= coins[j]) dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
         }
     }
     return dp[amount] == dp.length ? -1 : dp[amount];
 }

}

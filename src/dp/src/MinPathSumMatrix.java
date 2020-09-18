public class MinPathSumMatrix {
    public static int minPathSum(int[][] grid) {
        /*
            [0,1,4,5]
            [0,2,0,0]
            [0,0,0,0]
         */
        int m = grid.length;
        int n = grid[0].length;

        if (grid.length == 0) {
            return 0;
        }

        return minCostPath(grid, grid.length, grid[0].length);
    }

    public static int minCostPath(int[][] arr, int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        printDP(dp);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        printDP(dp);
        return dp[m - 1][n - 1];
    }

    public static void printDP(int[][] dp){
        for(int i = 0; i< dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println('\n');
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));


    }
}

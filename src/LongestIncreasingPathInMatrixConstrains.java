public class LongestIncreasingPathInMatrixConstrains {
    public static int n = 3;

    // This function mainly uses lookup table dp[n][n]
    static int findLongestFromACell(int i, int j, int mat[][], int dp[][])
    {
        // Base case
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;

        // If this subproblem is already solved
        if (dp[i][j] != -1)
            return dp[i][j];

        // To store the path lengths in all the four directions
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE, w = Integer.MIN_VALUE;

        if (j < n - 1 && (mat[i][j] - mat[i][j + 1] == 1))
            x = dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp);

        if (j > 0 && ( mat[i][j - 1] - mat[i][j] == 1))
            y = dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp);

        if (i > 0 && (mat[i - 1][j] - mat[i][j] == 1 ))
            z = dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp);

        if (i < n - 1 && (mat[i + 1][j] - mat[i][j]  == 1))
            w = dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp);

        // If none of the adjacent fours is one greater we will take 1
        // otherwise we will pick maximum from all the four directions
        return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1))));
    }

    // Function that returns length of the longest path
    // beginning with any cell
    static int finLongestOverAll(int mat[][])
    {
        // Initialize result
        int result = 1;

        // Create a lookup table and fill all entries in it as -1
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        // Compute longest path beginning from all cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    findLongestFromACell(i, j, mat, dp);

                // Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }

    /* ********* SOLUTION 2**************/

    public static int longestPath(int[][] matrix){
        return longestPath(matrix, 0,0,0);
    }

    private static int longestPath(int[][] matrix, int i, int j, int max){
        // if in the last row
//        if (i == matrix.length) return max;
//        // if in the last column
//        if (j == matrix[i].length)
//            return longestPath(matrix, i + 1, 0, max);

        max= Math.max(max, countSequences(matrix,i,j));
        return longestPath(matrix, i, j + 1, max);
    }
    private static int countSequences(int[][] matrix, int i, int j){
        // Base case
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;

        if(i < matrix.length-1 && matrix[i+1][j] - matrix[i][j] == 1)
            return 1+ countSequences(matrix, i+1, j);
        if(j < matrix[i].length-1 && matrix[i][j+1] - matrix[i][j] == 1)
            return 1+ countSequences(matrix, i, j+1);
        if(i > 0 && matrix[i-1][j] - matrix[i][j] == 1)
            return 1+ countSequences(matrix, i-1, j);
        if(j > 0 && matrix[i][j-1] - matrix[i][j] == 1)
            return 1+ countSequences(matrix, i, j-1);
        return 1;
    }
}

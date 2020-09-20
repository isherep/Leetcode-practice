package matrixes;

public class UniqueuPathRobot {
    int r, c = 0;

    public static int uniquePaths(int m, int n) {
        int res = 0;
        return 1 + helper(0, 0, m, n, res);
    }

    public static int helper(int r, int c, int m, int n, int res) {
        if (r >= m - 1 || c >= n - 1) return res;

        if (r < m - 1 && c < n - 1) {
            return 1 + helper(r + 1, c, m, n, res) + helper(r, c + 1, m, n, res);
        } else {
            return 0;
        }
        //return res;
    }

    public int uniquePathsMemo(int m, int n) {
        return uniquePathsHelper(m - 1, n - 1, new int[n][m]);
    }

    private int uniquePathsHelper(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else if (memo[n][m] > 0) {
            return memo[n][m];
        } else {
            memo[n][m] = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
            return memo[n][m];
        }
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }
}

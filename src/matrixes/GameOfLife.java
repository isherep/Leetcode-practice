package matrixes;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) return;
        int[][] directs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        // live with live neigh < 2 -> dies
        // live with live neigh > 3 -> dies
        // dead with live neigh == 3 -> becomes alive
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println(countAliveNeigh(copy,  directs));
                int live = countAliveNeigh(copy, directs, i, j);
                if (board[i][j] == 1 && live < 2 || live > 3) {
                    // count the number of live neighboors
                    board[i][j] = 0;
                } else {
                    if (live == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public static int countAliveNeigh(int[][] copy, int[][] directs, int i, int j) {
        int live = 0;
        for (int[] dir : directs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < copy.length && newY >= 0
                    && newY < copy[0].length
                    && copy[newX][newY] == 1) {
                live++;
            }
        }
        return live;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        printBoard(board);
    }
}

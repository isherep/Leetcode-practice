package matrixes;

public class MineSweaper {
    public char[][] updateBoard(char[][] board, int[] click) {
        return updateBoard1(board, click[0], click[1]);

    }

    public char[][] updateBoard1(char[][] board, int x, int y) {

        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        // if number adjacent cell has a mine
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && numOfAnjecent(board, x, y) > 0) {
            board[x][y] = (char) (numOfAnjecent(board, x, y) + '0');
            //return board;
            // stop recursion   30-38
        } else {
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length &&
                    board[x][y] != 'B'
                // (
                // board[x][y] <= 30 && board[x][y] >= 38)
            ) {
                board[x][y] = 'B';
                // recurse down top, left. right, up
                updateBoard1(board, x - 1, y);
                updateBoard1(board, x + 1, y);
                updateBoard1(board, x, y - 1);
                updateBoard1(board, x, y + 1);
            }
            return board;
        }
        return board;

    }

    public int numOfAnjecent(char[][] board, int x, int y) {
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int[] dir : directions) {
            int X = x + dir[0];
            int Y = y + dir[1];
            if (X >= 0 && Y >= 0 && X < board.length && Y < board[0].length) {
                if (board[X][Y] == 'M') count++;
            }

        }
        return count;
    }
}

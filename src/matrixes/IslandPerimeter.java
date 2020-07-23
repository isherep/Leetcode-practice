package matrixes;

public class IslandPerimeter {
    /*

    The description of this problem implies there may be an "pattern" in calculating
    the perimeter of the islands.
    and the pattern is islands * 4 - neighbours * 2,
    since every adjacent islands made two sides disappeared(as picture below).
    the next problem is: how to find the neighbours without missing or recounting?
    i was inspired by the problem: https://leetcode.com/problems/battleships-in-a-board/

    +--+     +--+                   +--+--+
    |  |  +  |  |          ->       |     |
    +--+     +--+                   +--+--+

    4 + 4 - ? = 6  -> ? = 2
     */

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // if it is a border cell with 1 - increment by 5
                if (grid[i][j] == 1) {
                    result += 4;
                    // if the row is not upper border one and upper is a 1
                    if (i > 0 && grid[i - 1][j] == 1)
                        result -= 2;
                    // if the row is not left border one
                    if (j > 0 && grid[i][j - 1] == 1)
                        result -= 2;
                }
            }
        }

        return result;
    }
}

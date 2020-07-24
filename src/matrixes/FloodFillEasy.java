package matrixes;

public class FloodFillEasy {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // first check if the new color is different from current, otherwise return
        if (image[sr][sc] == newColor) return image;
        // pass the starting color of the start cell
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int curColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        // if the cell is not of original color of the starting cell
        if (image[sr][sc] != curColor) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, curColor, newColor);
        fill(image, sr - 1, sc, curColor, newColor);
        fill(image, sr, sc + 1, curColor, newColor);
        fill(image, sr, sc - 1, curColor, newColor);
    }
}

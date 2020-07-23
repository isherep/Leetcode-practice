package matrixes;

public class RotateMatrix {
    public void rotateClockwise(int[][] matrix) {
        int n = matrix.length;
        // do n+1 for odd n??
        // if just i< n/2 - works only when n is even
        for(int i = 0; i < (n +1) / 2; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j]; // pull 1 into temp
                matrix[i][j] = matrix[n-j-1][i]; // put 13 into 1
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1]; // put 12 into 13
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1]; // put 10 into 12
                matrix[j][n-i-1] = temp; // put temp into 10
            }
        }
    }


    /*

    If transposing first - this is the outcome
    147
    258
    369
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // print transposed matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

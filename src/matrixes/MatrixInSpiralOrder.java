package matrixes;

public class MatrixInSpiralOrder {

    public static void main(String[] args){
        // create a matrix
        int[][] matrix = new int[3][3];
        int num = 1;
        for(int i = 0; i< matrix.length; i++){
            for(int j=0; j< matrix[i].length; j++){
               matrix[i][j] = num;
               num++;
               System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


        // print matrix in spiral order
        int top = 0;
        int bottom = matrix.length -1;
        int left = 0;
        int right = matrix.length -1;


        //while within matrix range
        while(top <= bottom && left <= right){
//printing first row
            for(int i = left; i<= right; i++){
                System.out.print(matrix[top][i]);
            }
            // move to the next row
            top++;
            //print last column
            for(int i = top; i<=bottom; i++){
                System.out.print(matrix[i][right]);

            }

            right--;
            // row
            for(int i = right; i >=left; i--){
                System.out.print(matrix[bottom][i]);
            }
            bottom --;
            //print first column
            for(int i = bottom; i >= top; i--){
                System.out.print(matrix[i][left]);
            }
            left ++;

        }
    }
}

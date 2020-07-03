package BinarySearch;

public class SearchIn2DMatrix2 {
    /*
       Use binary search on columns if the row satisfies condition
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int n = matrix.length;
        //int m = matrix[0].length;
        boolean res = false;
        // System.out.println("length "+matrix.length);
        for(int i = 0; i< matrix.length; i++){
            int m = matrix[i].length;
            if(n > 1){
                if(target >= matrix[i][0] || target <= matrix[i][m-1]){
                    // look inside that row
                    if(bs(matrix[i], target)){
                        res = true;
                        break;
                    }
                }
            } else {
                if(bs(matrix[i], target)){
                    res = true;
                    break;
                }
            }

        }
        return res;
    }

    public boolean bs(int[] nums, int t){
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == t){
                return true;
            }
            if(t < nums[mid]){
                hi = mid-1;
            } else { lo = mid+1;}
        }
        return false;
    }

    /******** LONGER WAY**************/
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        // select only rows where end > target
        // select only cols where con1 is < target
        int lIdx = 0;
        int cIdx = 0;
        for(int i=0; i<matrix.length; i++){
            //System.out.println(matrix[i][0]);
            if(matrix[i][0] > target){
                //System.out.print(matrix[i-1][0]);
                lIdx = i-1;
                break;
            }
            if(i==matrix.length-1) lIdx = i;
        }
        if(matrix.length > 1){

        }
        for(int i = 0; i< matrix[0].length; i++){
            if(matrix[0][i] > target){
                cIdx = i-1;
                break;
            }
            if(i == matrix[0].length-1) cIdx = i;
        }
        boolean res = false;
        int n = matrix.length;

        for(int i = 0; i<=lIdx; i++){
            //int m = matrix[i].length;
            if(n > 1){
                if(target >= matrix[i][0] || target <= matrix[i][cIdx]){
                    // look inside that row
                    if(bs(matrix[i], target, cIdx)){
                        res = true;
                        break;
                    }
                }
            } else {
                if(bs(matrix[i], target, cIdx)){
                    res = true;
                    break;
                }
            }

        }
        return res;
    }

    public boolean bs(int[] nums, int t, int hi){
        int lo = 0;
        //int hi = nums.length-1;
        while(lo <= hi){
            System.out.println("lo "+ lo + " hi " + hi + " nums[lo] " + nums[lo] + " num[hi] "+  nums[hi]);
            int mid = (lo + hi)/2;
            if(nums[mid] == t){
                return true;
            }
            if(t < nums[mid]){
                hi = mid-1;
            } else { lo = mid+1;}
        }
        return false;
    }

    /**********BEST WAY**********/
    public boolean searchMatrixBEST(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
    // same but start at top right corner
    public boolean searchMatrixR(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}

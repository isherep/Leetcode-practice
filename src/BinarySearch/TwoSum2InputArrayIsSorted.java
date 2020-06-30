package BinarySearch;

public class TwoSum2InputArrayIsSorted {
    /**
     * Using BST
     * The time complexity for this code I think is:
     * Recursive O (n*log n)
     * Iterative BST - O(n * log n)
     *
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 1){
            return res;
        }
        // initialize partner idx
        int idx2 = -1;
        // for every number in the array - check if there is a partner
        // using binary search, because array is sorted
        for(int i = 0; i< numbers.length; i++){ // this part in the worse case time -O(n-1)
            int num = numbers[i];
            int partner = target - num;
            // find the position of partner of it it exists
            // need to look only on the right, because the left already would
            // contain the partner - O(log n)
            idx2 = BST(numbers, partner, i+1, numbers.length - 1);
            // if partner found
            if(idx2 != -1){
                res[0] = i+1;
                res[1] = idx2+1;
                break;
            }
        }
        return res;
    }
    // Recursive - returns index of the partner
    public int BST(int[] arr, int partner, int lo, int hi){
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(arr[mid] == partner){
                return mid;
            }else if( partner > arr[mid]){
                return BST(arr, partner, mid+1, hi);
            }else{
                return BST(arr, partner, lo, mid-1);
            }
        }
        return -1;
    }
    // iterative
    public int BSTIterative(int[] arr, int partner, int lo, int hi){
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(arr[mid] == partner){
                return mid;
            }else if( partner > arr[mid]){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return -1;
    }
}

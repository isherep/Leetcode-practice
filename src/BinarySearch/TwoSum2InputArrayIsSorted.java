package BinarySearch;

public class TwoSum2InputArrayIsSorted {
    /**
     * RECURSIVE BST
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 1){
            return res;
        }
        int idx2 = -1;
        for(int i = 0; i< numbers.length; i++){
            int num = numbers[i];
            int partner = target - num;
            // find the position of partner of it it exists
            idx2 = BST(numbers, partner, i+1, numbers.length - 1);
            if(idx2 != -1){
                res[0] = i+1;
                res[1] = idx2+1;
                break;
            }
        }
        return res;
    }
    // returns index of the partner
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
}

package BinarySearch;

public class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        // find the start before rotation
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[lo] <= nums[mid] && nums[mid] <= nums[hi]){
                // case - not rotated
                return nums[lo];
                // else rotated - find the point of rotation
                // it is where the i < i+1
            } else {
                if( mid > 0 && nums[mid] <= nums[mid-1]){ // case [3,2,1]
                    return nums[mid];
                }
                if(nums[mid] >= nums[hi]) // mid > hi - look on the right
                {
                    lo = mid+1;
                } else {
                    //[6,7,0,.1.,2,3,4,5]
                    hi = mid-1;
                }
            }
        }
        return nums[lo];
    }
}

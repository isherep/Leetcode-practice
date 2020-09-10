package Array;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) return;
        int last = nums.length - 1;
        for (int i = 0; i < nums.length && i <= last; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                shift(nums, i, last);
                nums[last] = temp;
                last--;
                i--;
            }
        }
    }

    public void shift(int[] nums, int start, int last) {
        for (int i = start; i < last; i++) {
            nums[i] = nums[i + 1];
        }
    }


    // push all non zero numbers in the ancer pos
    // and increment the ancer
    // the rest will be left a 0 by Java's default
    public void moveZeroesOptimal(int[] nums) {
        if (nums == null || nums.length < 1) return;
        // i - explorer
        int ancer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[ancer];
                nums[ancer] = temp;
                ancer++;
            }
        }
    }

}

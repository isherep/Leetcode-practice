package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleArray {
    private int[] array;
    private int[] original;
    private int[] nums;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        this.nums = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    /** Brute-Force */
    public int[] shuffleOpt() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }
    /**
     * Fisher-Yates shuffle
     *
     * Proof: Suppose this algorithm works, i.e. for each position j (starting from 0), the probability of any number in the range[0,j] to be at position j is 1/(1+j).
     *
     * Let's look at int i = random.nextInt(j + 1):
     * (1) If i == j, nums[j] does not need to change its position, which has probability 1/(1+j).
     * (2) if i !=j, nums[j] needs to be swapped with nums[i]. The probability of any number x in the range [0,j-1] to be at position j = nums[j] changes its position * x is at position i
     * = (1-1/(1+j)) * (1/j) = 1/(1+j)
     *
     * Each number has equal probability to be at any position.
     *
     *

     Or you could just say that with three elements and using random.nextInt(size) you'd have 32 = 9 equally likely paths but 3! = 6 permutations, and you can't evenly distribute 9 paths over 6 permutations.
     */
    public int[] reset1() {
        return this.nums;
    }

    public int[] shuffle() {
        if(nums == null || nums.length < 1) return nums;
        int[] arr = nums.clone();
        for(int i = 1; i< arr.length; i++){
            int ranIdx = rand.nextInt(i+1);
            swap(arr, ranIdx, i);
        }
        return arr;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}

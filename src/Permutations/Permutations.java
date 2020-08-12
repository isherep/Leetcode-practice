package Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        // turn nums into arraylist
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int n : nums) {
            numsList.add(n);
        }
        backtrack(nums.length, numsList, result, 0);

        return result;
    }

    public void backtrack(int n, ArrayList<Integer> numsList, List<List<Integer>> result, int first) {
        // if first went over each number in the list
        // you need to clone the arraylist before adding, otherwise when you swap, all the added results will point to that swapped list, leaving you output full of same lists.

       // because you dont want to pass a reference to the array being modified each step.
        // you want a copy of the array at the moment in time appended to the output
        if (first == n) {
            result.add(new ArrayList<Integer>(numsList));
            // return;
        }
        // at this level here first doesn't change
        for (int i = first; i < n; i++) {
            // swap i and first
            Collections.swap(numsList, i, first);
            // now do the same for the rest of the array
            // go in depth further
            backtrack(n, numsList, result, first + 1);
            Collections.swap(numsList, i, first);

        }
    }

}
